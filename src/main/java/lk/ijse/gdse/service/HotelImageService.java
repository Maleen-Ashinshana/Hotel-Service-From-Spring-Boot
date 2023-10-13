package lk.ijse.gdse.service;

import lk.ijse.gdse.dto.HotelImageDTO;


public interface HotelImageService {
    HotelImageDTO saveImage(HotelImageDTO imageDTO);
    HotelImageDTO getSelectedHotelImage(String image_id);
    void updateHotelImage(HotelImageDTO imageDTO);
    void deleteHotelImage(String image_id);
}
