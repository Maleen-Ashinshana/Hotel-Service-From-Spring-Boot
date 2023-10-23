package lk.ijse.gdse.service;

import lk.ijse.gdse.dto.HotelDTO;

import java.util.List;


public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotelDTO);
    HotelDTO getSelectedHotel(String hotel_id);
    void updateHotel(String hotel_id,HotelDTO hotelDTO);
    void deleteHotel(String hotel_id);
    List<HotelDTO> gelAllHotels();
}
