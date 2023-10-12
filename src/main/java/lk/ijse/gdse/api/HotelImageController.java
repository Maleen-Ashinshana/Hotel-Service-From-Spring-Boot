package lk.ijse.gdse.api;

import jakarta.validation.Valid;

import lk.ijse.gdse.dto.HotelImageDTO;
import lk.ijse.gdse.service.HotelImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotelImage")
public class HotelImageController {
    private final HotelImageService hotelImageService;

    public HotelImageController(HotelImageService vehicleImageService) {
        this.hotelImageService = vehicleImageService;

    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    HotelImageDTO saveHotelImage(@Valid @RequestBody  HotelImageDTO imageDTO, Errors errors){
        return null;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HotelImageDTO> getHotel(@Valid @PathVariable String image_id){
        return null;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping()
    void deleteHotelImage(@Valid @PathVariable String image_id,@RequestBody  HotelImageDTO imageDTO,Errors errors){

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping()
    void updateHotelImage(@Valid @PathVariable String image_id,@RequestBody HotelImageDTO imageDTO,Errors errors){

    }
}
