package lk.ijse.gdse.service;

import lk.ijse.gdse.dto.HotelDTO;


public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotelDTO);
    HotelDTO getSelectedHotel(String hotel_id);
    void updateHotel(HotelDTO hotelDTO);
    void deleteHotel(String hotel_id);
}
