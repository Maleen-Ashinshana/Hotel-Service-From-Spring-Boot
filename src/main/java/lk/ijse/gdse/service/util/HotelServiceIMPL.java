package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.HotelDTO;
import lk.ijse.gdse.repo.HotelRepo;
import lk.ijse.gdse.service.HotelService;
import lk.ijse.gdse.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HotelServiceIMPL implements HotelService {
    @Autowired
    private Converter  convert;
    @Autowired
    private HotelRepo vehicleRepo;

    @Override
    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        return null;
    }

    @Override
    public HotelDTO getSelectedHotel(String hotel_id) {
        return null;
    }

    @Override
    public void updateHotel(HotelDTO hotelDTO) {

    }

    @Override
    public void deleteHotel(String hotel_id) {

    }
}
