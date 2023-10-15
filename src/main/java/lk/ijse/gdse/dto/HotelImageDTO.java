package lk.ijse.gdse.dto;

import lk.ijse.gdse.entity.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelImageDTO {
    private String image_id;
    private String front_image;
    private String back_image;
    private String inside_image;
    private String hotel_id;

    public HotelImageDTO(String image_id, String front_image, String back_image, String inside_image) {
        this.image_id = image_id;
        this.front_image = front_image;
        this.back_image = back_image;
        this.inside_image = inside_image;
    }
}
