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
@RequestMapping("/api/v1/hotel")
//@CrossOrigin("*")
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
    @GetMapping(/*value = "{code:[A-Fa-f0-9\\-]{36}}",produces = MediaType.APPLICATION_JSON_VALUE*/)
    /*@GetMapping("example/hotel_id")*/
    ResponseEntity<HotelDTO> getHotel(@Valid @RequestParam String hotel_id){
        HotelDTO hotelDTO=hotelService.getSelectedHotel(hotel_id);
        return  hotelDTO!=null?ResponseEntity.ok(hotelDTO):ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping()
    void deleteHotel(@Valid @RequestParam String hotel_id){
     hotelService.deleteHotel(hotel_id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping()
    void updateHotel(@Valid @RequestParam String hotel_id,/*@RequestBody*/ HotelDTO hotelDTO,Errors errors){
        hotelDTO.setHotel_id(hotel_id);
        hotelService.updateHotel(hotelDTO);
    }
}
