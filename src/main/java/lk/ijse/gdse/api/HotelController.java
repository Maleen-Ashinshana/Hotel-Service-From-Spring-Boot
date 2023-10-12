package lk.ijse.gdse.api;

import jakarta.validation.Valid;
import lk.ijse.gdse.dto.HotelDTO;

import lk.ijse.gdse.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    HotelDTO saveHotel(@Valid @RequestBody HotelDTO hotelDTO, Errors errors){
        return null;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HotelDTO> getVehicle(@Valid @PathVariable String hotel_id){
        return null;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping()
    void deleteHotel(@Valid @PathVariable String hotel_id,@RequestBody HotelDTO hotelDTO,Errors errors){

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping()
    void updateHotel(@Valid @PathVariable String hotel_id,@RequestBody HotelDTO hotelDTO,Errors errors){

    }
}
