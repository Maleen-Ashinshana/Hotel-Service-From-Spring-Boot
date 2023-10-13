package lk.ijse.gdse.api;

import jakarta.validation.Valid;

import lk.ijse.gdse.dto.HotelImageDTO;
import lk.ijse.gdse.service.HotelImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Arrays;
import java.util.Base64;

@RestController
@RequestMapping("/api/v1/hotelImage")
public class HotelImageController {
    private final HotelImageService hotelImageService;

    public HotelImageController(HotelImageService vehicleImageService) {
        this.hotelImageService = vehicleImageService;

    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    HotelImageDTO saveHotelImage(
            @RequestPart byte[] front_image,
            @RequestPart byte[] back_image,
        @RequestPart byte[] inside_image,
            @RequestPart String hotel_id){

        String front = Base64.getEncoder().encodeToString(front_image);
        String inside = Base64.getEncoder().encodeToString(inside_image);
        String back = Base64.getEncoder().encodeToString(back_image);

        HotelImageDTO imageDTO=new HotelImageDTO();

        imageDTO.setFront_image(Arrays.toString(new String[]{front}));
        imageDTO.setInside_image(Arrays.toString(new String[]{inside}));
        imageDTO.setBack_image(Arrays.toString(new String[]{back}));


        return hotelImageService.saveImage(imageDTO);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HotelImageDTO> getHotel(@Valid @RequestParam String image_id){
        HotelImageDTO hotelImageDTO=hotelImageService.getSelectedHotelImage(image_id);
        return hotelImageDTO!=null?ResponseEntity.ok(hotelImageDTO):ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping()
    void deleteHotelImage(@Valid @RequestParam String image_id,@RequestBody  HotelImageDTO imageDTO,Errors errors){
        hotelImageService.deleteHotelImage(image_id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping()
    void updateHotelImage(@Valid @RequestParam String image_id,@RequestBody HotelImageDTO imageDTO,Errors errors){
      imageDTO.setImage_id(Integer.parseInt(image_id));
      hotelImageService.updateHotelImage(imageDTO);
    }
}
