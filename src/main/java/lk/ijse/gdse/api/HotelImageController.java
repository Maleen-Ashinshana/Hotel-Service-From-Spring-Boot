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
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    HotelImageDTO saveHotelImage(
           /* @RequestParam HotelImageDTO imageDTO,*/
            @RequestPart byte[] front,
            @RequestPart byte[] back,
            @RequestPart byte[] inside,
            @RequestPart HotelEntity hotel_id
    ){

            String frontImg= Base64.getEncoder().encodeToString(front);
            String insideImg= Base64.getEncoder().encodeToString(inside);
            String backImg= Base64.getEncoder().encodeToString(back);

            HotelImageDTO imageDTO1=new HotelImageDTO();
//            imageDTO1.setHotelEntity(imageDTO);
            imageDTO1.setFront_image(frontImg);
            imageDTO1.setInside_image(insideImg);
            imageDTO1.setBack_image(backImg);
            imageDTO1.setHotelEntity(hotel_id);

            return hotelImageService.saveImage(imageDTO1);

    }

    /*ResponseEntity<HotelImageEntity,String> saveHotel(){

    }*/
/*    HotelImageDTO saveImage(@RequestParam MultipartFile file){
        try {
            byte[] front= file.getBytes();
            byte[] back= file.getBytes();
            byte[] inside= file.getBytes();
            HotelEntity hotel_id;

            String front_image=Base64.getEncoder().encodeToString(front);
            String inside_image=Base64.getEncoder().encodeToString(inside);
            String back_image=Base64.getEncoder().encodeToString(back);

            HotelImageDTO imageDTO=new HotelImageDTO();
            imageDTO.setFront_image(front_image);
            imageDTO.setBack_image(back_image);
            imageDTO.setInside_image(inside_image);
            *//*imageDTO.setHotelEntity(hotel_id);*//*

            return hotelImageService.saveImage(imageDTO);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
/*    HotelImageDTO saveHotelImage(
            @RequestParam byte[] front_image,
            @RequestParam byte[] back_image,
            @RequestParam byte[] inside_image,
            @RequestParam HotelEntity hotel_id){

        String font = Base64.getEncoder().encodeToString(front_image);
        String back = Base64.getEncoder().encodeToString(back_image);
        String inside = Base64.getEncoder().encodeToString(inside_image);

        HotelImageDTO imageDTO=new HotelImageDTO();
        imageDTO.setHotelEntity(hotel_id);
        imageDTO.setInside_image(inside);
        imageDTO.setBack_image(back);
        imageDTO.setFront_image(font);
        return  hotelImageService.saveImage(imageDTO);
    }*/

            /*@RequestPart HotelImageDTO imageDTO,
            @RequestPart List<MultipartFile> front_image,
            @RequestPart List<MultipartFile> inside_image,
            @RequestPart List<MultipartFile> back_image*/

        /*imageDTO.set*/
        /*String front = Base64.getEncoder().encodeToString(front_image);
        String inside = Base64.getEncoder().encodeToString(inside_image);
        String back = Base64.getEncoder().encodeToString(back_image);*/



       /* HotelImageDTO hotelImageDTO=new HotelImageDTO();
        hotelImageDTO.setFront_image(front);
        hotelImageDTO.setBack_image(back);
        hotelImageDTO.setInside_image(inside);*/




/*    HotelImageDTO saveHotelImage(
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
    }*/
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
