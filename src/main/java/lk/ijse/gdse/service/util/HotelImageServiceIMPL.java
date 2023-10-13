package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.HotelImageDTO;

import lk.ijse.gdse.entity.HotelImageEntity;
import lk.ijse.gdse.repo.HotelImageRepo;

import lk.ijse.gdse.service.HotelImageService;
import lk.ijse.gdse.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class HotelImageServiceIMPL implements HotelImageService {
    @Autowired
    private Converter convert;
    @Autowired
    private HotelImageRepo hotelImageRepo;


    @Override
    public HotelImageDTO saveImage(HotelImageDTO imageDTO) {
        return convert.toHotelImageDTO(hotelImageRepo.save(convert.toHotelImageEntity(imageDTO)));
    }

    @Override
    public HotelImageDTO getSelectedHotelImage(String image_id) {
        return convert.toHotelImageDTO(hotelImageRepo.getReferenceById(image_id));
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
