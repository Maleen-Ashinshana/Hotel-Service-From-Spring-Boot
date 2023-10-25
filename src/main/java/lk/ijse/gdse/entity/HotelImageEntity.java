package lk.ijse.gdse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "hotelImage")
public class HotelImageEntity implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String image_id;
    @Column(nullable = false ,columnDefinition = "LONGTEXT")
    @Lob
    private String hotel_images;


    @ManyToOne
    @JoinColumn(name = "hotel_id",referencedColumnName = "hotel_id")

    private HotelEntity hotelEntity;

    public HotelImageEntity(String image_id, String hotel_images) {
        this.image_id = image_id;
        this.hotel_images=hotel_images;
    }
}
