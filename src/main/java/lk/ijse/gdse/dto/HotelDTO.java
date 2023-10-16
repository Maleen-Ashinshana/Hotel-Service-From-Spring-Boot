package lk.ijse.gdse.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Data
@ToString
public class HotelDTO {
    @Null(message = "Hotel ID will auto generate")
    private String hotel_id;
    @NotNull(message = "Hotel name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]+")
    private  String hotel_name;
    @NotNull(message = "Hotel Category cannot be empty")
    private  String hotel_category;
    @NotNull(message = "Hotel Location cannot be empty")
    private  String location;
    @NotNull(message = "Hotel Email cannot be empty")
    private  String email;
    @NotNull(message = "Hotel Contact Number cannot be empty")
    private  int contact_number;



    public HotelDTO(String hotel_id, String hotel_name, String hotel_category, String location, String email, int contact_number) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_category = hotel_category;
        this.location = location;
        this.email = email;
        this.contact_number = contact_number;
    }
}
