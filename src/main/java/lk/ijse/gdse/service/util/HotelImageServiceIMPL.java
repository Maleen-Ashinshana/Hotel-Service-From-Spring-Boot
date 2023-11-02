package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.HotelImageDTO;

import lk.ijse.gdse.entity.HotelEntity;
import lk.ijse.gdse.entity.HotelImageEntity;
import lk.ijse.gdse.exception.NotFoundException;
import lk.ijse.gdse.repo.HotelImageRepo;

import lk.ijse.gdse.repo.HotelRepo;
import lk.ijse.gdse.service.HotelImageService;
import lk.ijse.gdse.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelImageServiceIMPL implements HotelImageService {

    private final Converter convert;

    private final HotelImageRepo hotelImageRepo;
    private  final HotelRepo hotelRepo;


    @Override
    public HotelImageDTO saveImage(String hotel_id, HotelImageDTO imageDTO) {
        HotelEntity hotelEntity = hotelRepo.findById(hotel_id).orElseThrow();
        HotelImageEntity hotelImageEntity = convert.toHotelImageEntity(imageDTO);
        hotelImageEntity.setHotelEntity(hotelEntity);
        HotelImageDTO hotelImageDTO = convert.toHotelImageDTO(hotelImageRepo.save(hotelImageEntity));
        System.out.println(hotelImageDTO);
        return hotelImageDTO;


//        return convert.toHotelImageDTO(hotelImageRepo.save(convert.toHotelImageEntity(imageDTO)));
    }
  /* @Override
    public List<HotelImageDTO> saveImages(String hotel_id, List<HotelImageDTO> imageDTOs) {
        HotelEntity hotelEntity = hotelRepo.findById(hotel_id).orElseThrow();
        List<HotelImageDTO> savedImageDTOs = new ArrayList<>();

        for (HotelImageDTO imageDTO : imageDTOs) {
            HotelImageEntity hotelImageEntity = convert.toHotelImageEntity(imageDTO);
            hotelImageEntity.setHotelEntity(hotelEntity);
            HotelImageEntity savedHotelImageEntity = hotelImageRepo.save(hotelImageEntity);
            savedImageDTOs.add(convert.toHotelImageDTO(savedHotelImageEntity));
        }

        System.out.println(savedImageDTOs);
        return savedImageDTOs;
    }*/


   /* @Override
    public HotelImageDTO saveImage(String hotel_id, HotelImageDTO imageDTO) {
        return null;
    }*/

    /*@Override
    public HotelImageDTO getSelectedHotelImage(String image_id) {
        // Use Optional to handle the case where the image is not found
        Optional<HotelImageEntity> optionalHotelImageEntity = hotelImageRepo.findById(image_id);

        // Check if the image exists; if not, throw a NotFoundException
        if (optionalHotelImageEntity.isEmpty()) {
            throw new NotFoundException("Hotel Image ID Not Found: " + image_id);
        }

        HotelImageEntity hotelImageEntity = optionalHotelImageEntity.get();

        HotelImageDTO hotelImageDTO = convert.toHotelImageDTO(hotelImageEntity);

        // Set additional properties as needed
        hotelImageDTO.setHotel_id(hotelImageEntity.getHotelEntity().getHotel_id());

        // Convert the image to a byte array if it's stored as a byte array in the entity
        byte[] imageBytes = hotelImageEntity.getHotel_images().getBytes();

        // Check for null before setting the image bytes
        if (imageBytes != null) {
            hotelImageDTO.setHotel_images(imageBytes);
        }

        return hotelImageDTO;
    }*/

    public HotelImageDTO getSelectedHotelImage(String image_id) {
        HotelImageEntity hotelImageEntity = hotelImageRepo.findById(image_id)
                .orElseThrow(() -> new NotFoundException("Hotel Image ID Not Found: " + image_id));

        HotelImageDTO hotelImageDTO = convert.toHotelImageDTO(hotelImageEntity);

        // Set additional properties as needed
        hotelImageDTO.setHotel_id(hotelImageEntity.getHotelEntity().getHotel_id());

        // Convert the image to a byte array if it's stored as a byte array in the entity
        byte[] imageBytes = hotelImageEntity.getHotel_images().getBytes();
        if (imageBytes != null) {
            hotelImageDTO.setHotel_images(imageBytes);
        }

        return hotelImageDTO;
    }

   /* public HotelImageDTO getSelectedHotelImage(String image_id) {
        HotelImageEntity hotelImageEntity = hotelImageRepo.findById(image_id).orElseThrow(()->new NotFoundException("Hotel Image Id Not Found "+image_id));
        HotelImageDTO hotelImageDTO = convert.toHotelImageDTO(hotelImageEntity);
        hotelImageDTO.setHotel_id(hotelImageEntity.getHotelEntity().getHotel_id());
        hotelImageDTO.setHotel_images(hotelImageEntity.getHotel_images().getBytes());
        System.out.println(hotelImageDTO.getHotel_images()+"lakaakakakak");
        return hotelImageDTO;

//        return convert.toHotelImageDTO(hotelImageRepo.findById(image_id).get());
    }*/

    @Override
    public void updateHotelImage(String image_id,HotelImageDTO imageDTO) {
        Optional<HotelImageEntity> imageEntity=hotelImageRepo.findById(image_id);
       if (imageEntity.isEmpty()){
           throw new NotFoundException("Hotel Image ID :"+ image_id + "Note Found" );

       }
       HotelImageEntity hotelImageEntity=imageEntity.get();
       hotelImageEntity.setHotel_images(Arrays.toString(imageDTO.getHotel_images()));
       hotelImageRepo.save(hotelImageEntity);
    }

    @Override
    public void deleteHotelImage(String image_id) {
        // Check if the hotel image with the given image_id exists
        Optional<HotelImageEntity> optionalHotelImage = hotelImageRepo.findById(image_id);

        if (optionalHotelImage.isPresent()) {
            // If the image exists, delete it
            hotelImageRepo.deleteById(image_id);
        } else {
            // If the image does not exist, throw an exception
            throw new NotFoundException("Hotel Image ID not found: " + image_id);
        }
    }


    @Override
    public List<HotelImageDTO> gelAllHotelIamges() {
        return hotelImageRepo.findAll().stream().map(hotelImage->convert.toHotelImageDTO(hotelImage)).collect(Collectors.toList());
    }
}
