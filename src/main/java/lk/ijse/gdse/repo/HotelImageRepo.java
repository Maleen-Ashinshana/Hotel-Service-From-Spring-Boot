package lk.ijse.gdse.repo;

import lk.ijse.gdse.entity.HotelImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelImageRepo extends JpaRepository<HotelImageEntity,String> {
    HotelImageEntity save(HotelImageEntity imageEntity);
    HotelImageEntity getByImage_id(String image_id);
    void deleteByImage_id(String image_id);

}
