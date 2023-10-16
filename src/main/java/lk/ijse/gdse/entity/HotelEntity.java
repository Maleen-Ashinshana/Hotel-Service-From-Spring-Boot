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
    private  int contact_number;

    @OneToMany(mappedBy = "hotelEntity") // Assuming 'hotel' is the property in HotelImageEntity that maps back to this entity
    private List<HotelImageEntity> images;

    public HotelEntity(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public HotelEntity(String hotel_id, String hotel_name, String hotel_category, String location, String email, int contact_number) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_category = hotel_category;
        this.location = location;
        this.email = email;
        this.contact_number = contact_number;
    }
}
