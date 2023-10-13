package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.HotelDTO;
import lk.ijse.gdse.entity.HotelEntity;
import lk.ijse.gdse.repo.HotelRepo;
import lk.ijse.gdse.service.HotelService;
import lk.ijse.gdse.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class HotelServiceIMPL implements HotelService {
    @Autowired
    private Converter  convert;
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        return convert.toHotelDTO(hotelRepo.save(convert.toHotelEntity(hotelDTO)));
    }

    @Override
    public HotelDTO getSelectedHotel(String hotel_id) {

        return convert.toHotelDTO(hotelRepo.getReferenceById(hotel_id));
    }

    @Override
    public void updateHotel(HotelDTO hotelDTO) {
        Optional <HotelEntity> hotelEntity=hotelRepo.findById(hotelDTO.getHotel_id());
        if(!hotelEntity.isPresent()){
            hotelEntity.get().setHotel_name(hotelDTO.getHotel_name());
            hotelEntity.get().setHotel_category(hotelDTO.getHotel_category());
            hotelEntity.get().setLocation(hotelDTO.getLocation());
            hotelEntity.get().setEmail(hotelDTO.getEmail());
            hotelEntity.get().setContact_number(hotelDTO.getContact_number());
        }
    }
    @Override
    public void deleteHotel(String hotel_id) {
   hotelRepo.deleteById(hotel_id);
    }
}
