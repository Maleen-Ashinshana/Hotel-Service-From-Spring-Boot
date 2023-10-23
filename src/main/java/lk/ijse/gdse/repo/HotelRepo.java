package lk.ijse.gdse.repo;

import lk.ijse.gdse.dto.HotelDTO;
import lk.ijse.gdse.entity.HotelEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<HotelEntity, String> {
    HotelEntity save(HotelDTO hotelDTO);
//    HotelEntity save(HotelEntity hotelEntity);
 /*  HotelEntity getByHotel_id(String hotel_id);
    void  deleteByHotel_id(String hotel_id);*/
List<HotelEntity> findAll();

}
