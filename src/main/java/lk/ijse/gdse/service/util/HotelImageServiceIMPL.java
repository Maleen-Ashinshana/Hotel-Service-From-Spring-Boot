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
    public void updateHotelImage(HotelImageDTO imageDTO) {
        Optional<HotelImageEntity> imageEntity=hotelImageRepo.findById(String.valueOf(imageDTO.getImage_id()));
       if (!imageEntity.isPresent()){
           imageEntity.get().setBack_image(imageDTO.getBack_image());
           imageEntity.get().setInside_image(imageDTO.getInside_image());
           imageEntity.get().setFront_image(imageDTO.getFront_image());
       }
    }

    @Override
    public void deleteHotelImage(String image_id) {
    hotelImageRepo.deleteById(image_id);
    }
}
