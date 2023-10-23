package lk.ijse.gdse.repo;

import lk.ijse.gdse.entity.HotelImageEntity;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelImageRepo extends CrudRepository<HotelImageEntity,String> {
    /*HotelImageEntity save(HotelImageEntity imageEntity);
    HotelImageEntity getByImage_id(String image_id);
    void deleteByImage_id(String image_id);*/
    List<HotelImageEntity> findAll();

}
