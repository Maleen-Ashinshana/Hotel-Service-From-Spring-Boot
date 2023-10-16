package lk.ijse.gdse.api;

import jakarta.validation.Valid;

import lk.ijse.gdse.dto.HotelImageDTO;
import lk.ijse.gdse.entity.HotelEntity;
import lk.ijse.gdse.entity.HotelImageEntity;
import lk.ijse.gdse.service.HotelImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotelImage")
@CrossOrigin("*")
public class HotelImageController {
    private final HotelImageService hotelImageService;

    public HotelImageController(HotelImageService vehicleImageService) {
        this.hotelImageService = vehicleImageService;

    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{hotel_id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveHotelImage(
           /* @RequestParam HotelImageDTO imageDTO,*/
            @RequestPart byte[] front,
            @RequestPart byte[] back,
            @RequestPart byte[] inside,

            @PathVariable String hotel_id){

            String frontImg= Base64.getEncoder().encodeToString(front);
            String insideImg= Base64.getEncoder().encodeToString(inside);
            String backImg= Base64.getEncoder().encodeToString(back);

            HotelImageDTO imageDTO1=new HotelImageDTO();
//            imageDTO1.setHotelEntity(imageDTO);
            imageDTO1.setFront_image(frontImg);
            imageDTO1.setInside_image(insideImg);
            imageDTO1.setBack_image(backImg);

        System.out.println(imageDTO1.getImage_id()+"+*****");
//            imageDTO1.setHotelEntity(hotel_id);

            return hotelImageService.saveImage(hotel_id,imageDTO1).getImage_id();

    }
    @GetMapping(value = "/{image_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HotelImageDTO> getHotel(@Valid @PathVariable String image_id){
        HotelImageDTO hotelImageDTO=hotelImageService.getSelectedHotelImage(image_id);
        return new ResponseEntity<>(hotelImageDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{image_id}")
    void deleteHotelImage(@Valid @PathVariable String image_id){
        hotelImageService.deleteHotelImage(image_id);
    }

    @PatchMapping("/{image_id}")
    public String updateHotelImage(
            @RequestPart byte[] front,
            @RequestPart byte[] back,
            @RequestPart byte[] inside,

            @PathVariable String image_id){
        String frontImg= Base64.getEncoder().encodeToString(front);
        String insideImg= Base64.getEncoder().encodeToString(inside);
        String backImg= Base64.getEncoder().encodeToString(back);

        HotelImageDTO imageDTO1=new HotelImageDTO();
//            imageDTO1.setHotelEntity(imageDTO);
        imageDTO1.setFront_image(frontImg);
        imageDTO1.setInside_image(insideImg);
        imageDTO1.setBack_image(backImg);

        hotelImageService.updateHotelImage(image_id,imageDTO1);
        return String.valueOf(new ResponseEntity<>(HttpStatus.OK));
    }
}
