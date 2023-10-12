package lk.ijse.gdse.util;


import lk.ijse.gdse.dto.HotelDTO;
import lk.ijse.gdse.dto.HotelImageDTO;
import lk.ijse.gdse.entity.HotelEntity;
import lk.ijse.gdse.entity.HotelImageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    public HotelImageEntity toHotelImageEntity(HotelImageDTO imageDTO){
        return modelMapper.map(imageDTO, HotelImageEntity.class);
    }
    public  HotelImageDTO toHotelImageDTO(HotelImageEntity imageEntity){
        return modelMapper.map(imageEntity, HotelImageDTO.class);
    }
}
