package lk.ijse.gdse.util;


import lk.ijse.gdse.dto.HotelDTO;
import lk.ijse.gdse.dto.HotelImageDTO;
import lk.ijse.gdse.entity.HotelEntity;
import lk.ijse.gdse.entity.HotelImageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;

@Component
public class Converter {
    private final ModelMapper modelMapper;

    public Converter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HotelEntity toHotelEntity(HotelDTO hotelDTO){
        return modelMapper.map(hotelDTO, HotelEntity.class);
    }
    public  HotelDTO toHotelDTO(HotelEntity hotelEntity){
        List<HotelImageEntity> imageEntities=hotelEntity.getImages();
        HotelDTO map = modelMapper.map(hotelEntity, HotelDTO.class);
        if (imageEntities!=null){
            map.setImageDTOS(
                    imageEntities.stream().map(h->new HotelImageDTO(h.getImage_id(),
                            Base64.getDecoder().decode(h.getHotel_images()),
                            hotelEntity.getHotel_id())).toList());

        }
        return map;
        /*return modelMapper.map(hotelEntity, HotelDTO.class);*/
    }

    public HotelImageEntity toHotelImageEntity(HotelImageDTO imageDTO){
        HotelImageEntity map = modelMapper.map(imageDTO, HotelImageEntity.class);
        map.setHotel_images(Base64.getEncoder().encodeToString(imageDTO.getHotel_images()));
        return map;
        /*return modelMapper.map(imageDTO, HotelImageEntity.class);*/
    }
    public  HotelImageDTO toHotelImageDTO(HotelImageEntity imageEntity){
        return modelMapper.map(imageEntity, HotelImageDTO.class);
    }
}
