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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

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

    @Override
    public HotelImageDTO getSelectedHotelImage(String image_id) {
        HotelImageEntity hotelImageEntity = hotelImageRepo.findById(image_id).orElseThrow(()->new NotFoundException("Hotel Image Id Not Found "+image_id));
        HotelImageDTO hotelImageDTO = convert.toHotelImageDTO(hotelImageEntity);
        hotelImageDTO.setHotel_id(hotelImageEntity.getHotelEntity().getHotel_id());
        return hotelImageDTO;

//        return convert.toHotelImageDTO(hotelImageRepo.findById(image_id).get());
    }

    @Override
    public void updateHotelImage(String image_id,HotelImageDTO imageDTO) {
        Optional<HotelImageEntity> imageEntity=hotelImageRepo.findById(image_id);
       if (!imageEntity.isPresent()){
           throw new NotFoundException("Hotel Image ID :"+ image_id + "Note Found" );

       }
       HotelImageEntity hotelImageEntity=imageEntity.get();
       hotelImageEntity.setFront_image(imageDTO.getFront_image());
       hotelImageEntity.setInside_image(imageDTO.getInside_image());
       hotelImageEntity.setBack_image(imageDTO.getBack_image());
    }

    @Override
    public void deleteHotelImage(String image_id) {
        Optional<HotelImageEntity> byId = hotelImageRepo.findById(image_id);
        if (!byId.isPresent()){
            throw new NotFoundException("Hotel Image ID :" + image_id+ " Not Found");
        }
        hotelImageRepo.deleteById(image_id);
    }
}
