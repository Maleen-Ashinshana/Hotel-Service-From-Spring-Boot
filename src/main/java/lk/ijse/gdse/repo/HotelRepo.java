package lk.ijse.gdse.repo;

import lk.ijse.gdse.entity.HotelEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<HotelEntity, String> {
    HotelEntity save(HotelEntity hotelEntity);
    HotelEntity getByHotel_id(String hotel_id);
    void  deleteByHotel_id(String hotel_id);

}
