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
import java.util.ArrayList;
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
    public HotelImageDTO  saveHotelImage(

            @RequestPart List<MultipartFile> hotel_image,
            @PathVariable String hotel_id){
        List<byte[]> hotelImagesData = new ArrayList<>();

        /*String VImag= Base64.getEncoder().encodeToString(vehicle_image);*/
        for (MultipartFile image : hotel_image) {
            HotelImageDTO imageDTO=new HotelImageDTO();
            try {
                imageDTO.setHotel_images(image.getBytes());
               /* byte[] imageData = image.getBytes();
                vehicleImagesData.add(imageData);*/
            } catch (IOException e) {
                e.printStackTrace();
            }
            return hotelImageService.saveImage(hotel_id, imageDTO);

        }
        return null ;
            /*List<byte[]> bytes=new ArrayList<>();

            for(MultipartFile file:hotel_image){
       HotelImageDTO imageDTO=new HotelImageDTO();
                try {
                    imageDTO.setHotel_images(file.getBytes());
                   *//* byte[] imageData=file.getBytes();*//*
                    *//*bytes.add(imageData);*//*
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String imageId = hotelImageService.saveImage(hotel_id, imageDTO).getImage_id();

            }
            return "Saved";*/
            //return String.valueOf(new ResponseEntity<>(HttpStatus.OK));

     /*       HotelImageDTO imageDTO1=new HotelImageDTO();
//            imageDTO1.setHotelEntity(imageDTO);
            imageDTO1.setHotel_images(bytes.toString());
        System.out.println(imageDTO1.getImage_id()+"+*****");
//            imageDTO1.setHotelEntity(hotel_id);
        System.out.println(vehicle_image);*/

            /*return hotelImageService.saveImage(hotel_id,imageDTO1).getImage_id();*/

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
            @RequestPart List<MultipartFile> hotel_image,

            @PathVariable String image_id){
        List<byte[]> hotelImagesData = new ArrayList<>();

        /*String VImag= Base64.getEncoder().encodeToString(vehicle_image);*/
        for (MultipartFile image : hotel_image) {
            HotelImageDTO imageDTO=new HotelImageDTO();
            try {
                imageDTO.setHotel_images(image.getBytes());
               /* byte[] imageData = image.getBytes();
                vehicleImagesData.add(imageData);*/
            } catch (IOException e) {
                e.printStackTrace();
            }
            hotelImageService.updateHotelImage(image_id,imageDTO);

        }
        return "Updated";

        /*List<byte[]> bytes=new ArrayList<>();
        for(MultipartFile file:vehicle_image){
            try {
                byte[] imageData=file.getBytes();
                bytes.add(imageData);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        HotelImageDTO imageDTO1=new HotelImageDTO();
        imageDTO1.setHotel_images(vehicle_image.toString().getBytes());
//            imageDTO1.setHotelEntity(imageDTO);


        hotelImageService.updateHotelImage(image_id,imageDTO1);
        return String.valueOf(new ResponseEntity<>(HttpStatus.OK));*/
    }
    @GetMapping
    public ResponseEntity<List<HotelImageDTO>> getAllHotelImage() {
        List<HotelImageDTO> dto = hotelImageService.gelAllHotelIamges();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
