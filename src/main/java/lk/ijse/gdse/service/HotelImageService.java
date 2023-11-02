package lk.ijse.gdse.service;

import lk.ijse.gdse.dto.HotelDTO;
import lk.ijse.gdse.dto.HotelImageDTO;

import java.util.List;


public interface HotelImageService {
    /* @Override*/
     /*public HotelImageDTO saveImage(String hotel_id, HotelImageDTO imageDTO) {
         HotelEntity hotelEntity = hotelRepo.findById(hotel_id).orElseThrow();
         HotelImageEntity hotelImageEntity = convert.toHotelImageEntity(imageDTO);
         hotelImageEntity.setHotelEntity(hotelEntity);
         HotelImageDTO hotelImageDTO = convert.toHotelImageDTO(hotelImageRepo.save(hotelImageEntity));
         System.out.println(hotelImageDTO);
         return hotelImageDTO;


 //        return convert.toHotelImageDTO(hotelImageRepo.save(convert.toHotelImageEntity(imageDTO)));
     }*/
   /* List<HotelImageDTO> saveImages(String hotel_id, List<HotelImageDTO> imageDTOs);*/

    HotelImageDTO saveImage(String hotel_id, HotelImageDTO imageDTO);
    HotelImageDTO getSelectedHotelImage(String image_id);
    void updateHotelImage(String image_id,HotelImageDTO imageDTO);
    void deleteHotelImage(String image_id);
    List<HotelImageDTO> gelAllHotelIamges();
}
