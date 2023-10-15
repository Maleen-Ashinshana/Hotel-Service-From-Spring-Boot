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
    private String front_image;
    @Column(nullable = false ,columnDefinition = "LONGTEXT" )
    @Lob
    private String back_image;
    @Column(nullable = false ,columnDefinition = "LONGTEXT")
    @Lob
    private String inside_image;
    @ManyToOne
    @JoinColumn(name = "hotel_id",referencedColumnName = "hotel_id")

    private HotelEntity hotelEntity;

    public HotelImageEntity(String image_id, String front_image, String back_image, String inside_image) {
        this.image_id = image_id;
        this.front_image = front_image;
        this.back_image = back_image;
        this.inside_image = inside_image;
    }
}
