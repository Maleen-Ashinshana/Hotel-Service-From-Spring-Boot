package lk.ijse.gdse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "hotel")
public class HotelEntity implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String hotel_id;
    @Column(nullable = false)
    private  String hotel_name;
    @Column(nullable = false)
    private  String hotel_category;
    @Column(nullable = false)
    private  String location;
    @Column(nullable = false)

    private  String email;
    @Column(nullable = false)
    private  String contact_number1;
    @Column(nullable = false)
    private  String contact_number2;
    @Column(nullable = false)
    private  double hotelFee;
    @Column(nullable = false)
    private  String remark;

    @OneToMany(mappedBy = "hotelEntity")
    private List<HotelImageEntity> images;

    public HotelEntity(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public HotelEntity(String hotel_id, String hotel_name, String hotel_category, String location, String email, String contact_number1, String contact_number2, double hotelFee, String remark) {
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
