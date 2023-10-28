package lk.ijse.gdse.dto;

import jakarta.validation.constraints.Null;
import lk.ijse.gdse.entity.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelImageDTO {
    @Null(message = "Hotel ID will auto generate")
    private String image_id;
    private byte[] hotel_images;
    private String hotel_id;

    public HotelImageDTO(String image_id, byte[] hotel_images) {
        this.image_id = image_id;
        this.hotel_images = hotel_images;
    }


}
