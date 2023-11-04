package lk.ijse.gdse.dto;

import jakarta.validation.constraints.*;
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
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid hotel name format")
    private  String hotel_name;
    @NotNull(message = "Hotel Category cannot be empty")
    private  String hotel_category;
    @NotNull(message = "Hotel Location cannot be empty")
    private  String location;
    @NotNull(message = "Hotel Email cannot be empty")
    @Email(message = "Invalid email format")
    private  String email;
    @NotNull(message = "Hotel Contact Number1 cannot be empty")
    @Size( max = 15, message = "Contact number 1 should be between 10characters")
    private  String contact_number1;
    @NotNull(message = "Contact number 2 cannot be empty")
    @Size( max = 15, message = "Contact number 2 should be between 10characters")
    private  String contact_number2;
    @PositiveOrZero(message = "Hotel fee cannot be negative")
    private  double hotelFee;
    @NotNull(message = "Hotel Remark cannot be empty")
    private  String remark;

    private List<HotelImageDTO> imageDTOS=new ArrayList<>();

}
