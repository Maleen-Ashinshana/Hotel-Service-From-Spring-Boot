package lk.ijse.gdse.service;

import lk.ijse.gdse.dto.HotelImageDTO;


public interface HotelImageService {
    HotelImageDTO saveHotel(HotelImageDTO imageDTO);
    HotelImageDTO getSelectedHotel(String image_id);
    void updateHotel(HotelImageDTO imageDTO);
    void deleteHotel(String image_id);
}
