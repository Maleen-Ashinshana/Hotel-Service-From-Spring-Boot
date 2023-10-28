package lk.ijse.gdse.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
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
    @NotNull(message = "Hotel Contact Number1 cannot be empty")
    private  String contact_number1;
    @NotNull(message = "Hotel Contact Number2 cannot be empty")
    private  String contact_number2;
    @NotNull(message = "Hotel HotelFee cannot be empty")
    private  double hotelFee;
    @NotNull(message = "Hotel Remark cannot be empty")
    private  String remark;

    private List<HotelImageDTO> imageDTOS=new ArrayList<>();

    public HotelDTO(String hotel_id, String hotel_name, String hotel_category, String location, String email, String contact_number1, String contact_number2, double hotelFee, String remark) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_category = hotel_category;
        this.location = location;
        this.email = email;
        this.contact_number1 = contact_number1;
        this.contact_number2 = contact_number2;
        this.hotelFee = hotelFee;
        this.remark = remark;
    }
}
