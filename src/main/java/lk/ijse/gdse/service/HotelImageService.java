package lk.ijse.gdse.service;

import lk.ijse.gdse.dto.HotelImageDTO;


public interface HotelImageService {
    HotelImageDTO saveImage(String hotel_id, HotelImageDTO imageDTO);
    HotelImageDTO getSelectedHotelImage(String image_id);
    void updateHotelImage(String image_id,HotelImageDTO imageDTO);
    void deleteHotelImage(String image_id);
}
