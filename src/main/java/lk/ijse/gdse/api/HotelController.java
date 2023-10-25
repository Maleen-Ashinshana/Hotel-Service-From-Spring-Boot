package lk.ijse.gdse.api;

import jakarta.validation.Valid;
import lk.ijse.gdse.dto.HotelDTO;

import lk.ijse.gdse.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
@CrossOrigin("*")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    HotelDTO saveHotel(@Valid @RequestBody HotelDTO hotelDTO){
        return hotelService.saveHotel(hotelDTO);
    }
    @GetMapping("/{hotel_id}")
    ResponseEntity<HotelDTO> getHotel(@Valid @PathVariable String hotel_id){
        HotelDTO hotelDTO=hotelService.getSelectedHotel(hotel_id);
        return  new ResponseEntity<>(hotelDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{hotel_id}")
    void deleteHotel(@Valid @PathVariable String hotel_id){
     hotelService.deleteHotel(hotel_id);
    }

    @PatchMapping("/{hotel_id}")
    void updateHotel(@Valid @PathVariable String hotel_id,@RequestBody HotelDTO hotelDTO){
        hotelService.updateHotel(hotel_id,hotelDTO);

//        hotelDTO.setHotel_id(hotel_id,hotelDTO);
//        hotelService.updateHotel(hotel_id,hotelDTO);
    }
    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        List<HotelDTO> dto = hotelService.gelAllHotels();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
