package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.HotelImageDTO;

import lk.ijse.gdse.repo.HotelImageRepo;

import lk.ijse.gdse.service.HotelImageService;
import lk.ijse.gdse.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HotelImageServiceIMPL implements HotelImageService {
    @Autowired
    private Converter convert;
    @Autowired
    private HotelImageRepo hotelImageRepo;


    @Override
    public HotelImageDTO saveHotel(HotelImageDTO imageDTO) {
        return null;
    }

    @Override
    public HotelImageDTO getSelectedHotel(String image_id) {
        return null;
    }

    @Override
    public void updateHotel(HotelImageDTO imageDTO) {

    }

    @Override
    public void deleteHotel(String image_id) {

    }
}
