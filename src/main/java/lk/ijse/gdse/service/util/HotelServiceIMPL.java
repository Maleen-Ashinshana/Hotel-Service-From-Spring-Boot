package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.HotelDTO;
import lk.ijse.gdse.entity.HotelEntity;
import lk.ijse.gdse.exception.NotFoundException;
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
    private Converter convert;
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        return convert.toHotelDTO(hotelRepo.save(convert.toHotelEntity(hotelDTO)));
        //HotelEntity hotelEntity=convert.toHotelImageEntity(hotelDTO);
        //HotelDTO hotelDTO1=convert.toHotelImageEntity(hotelDTO);
        //return convert.toHotelDTO(hotelRepo.(convert.toHotelEntity(hotelDTO)));
    }

    @Override
    public HotelDTO getSelectedHotel(String hotel_id) {
        Optional<HotelEntity> byId = hotelRepo.findById(hotel_id);
        if(!byId.isPresent()){
            throw new NotFoundException("Hotel :" +hotel_id+ " Not Fount");

        }
        return convert.toHotelDTO(byId.get());
//        if (!hotelRepo.existsById(hotel_id))
//        return convert.toHotelDTO(hotelRepo.findById(hotel_id).get());
    }

    @Override
    public void updateHotel(String hotel_id,HotelDTO hotelDTO) {
        Optional<HotelEntity> hotelEntity = hotelRepo.findById(hotel_id);
        System.out.println(hotel_id+"IMPL");
        if (!hotelEntity.isPresent()) {
            throw new NotFoundException("Hotel ID : "+ hotel_id+ " Not Found");

        }
        HotelEntity hotelEntity1=hotelEntity.get();
        hotelEntity1.setHotel_name(hotelDTO.getHotel_name());
        hotelEntity1.setHotel_category(hotelDTO.getHotel_category());
        hotelEntity1.setLocation(hotelDTO.getLocation());
        hotelEntity1.setEmail(hotelDTO.getEmail());
        hotelEntity1.setContact_number(hotelDTO.getContact_number());

        hotelRepo.save(hotelEntity1);
//        hotelEntity.get().setHotel_name(hotelDTO.getHotel_name());
//        hotelEntity.get().setHotel_category(hotelDTO.getHotel_category());
//        hotelEntity.get().setLocation(hotelDTO.getLocation());
//        hotelEntity.get().setEmail(hotelDTO.getEmail());
//        hotelEntity.get().setContact_number(hotelDTO.getContact_number());
//
//        hotelRepo.save(convert.toHotelEntity(hotelDTO));
    }


    @Override
    public void deleteHotel(String hotel_id) {
        Optional<HotelEntity> byId = hotelRepo.findById(hotel_id);
        if (!byId.isPresent()){
            throw new NotFoundException("Hotel ID :" + hotel_id+ " Not Found");
        }
        hotelRepo.deleteById(hotel_id);

    }
}
