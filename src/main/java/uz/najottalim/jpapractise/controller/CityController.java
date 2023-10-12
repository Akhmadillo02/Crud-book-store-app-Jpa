package uz.najottalim.jpapractise.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.jpapractise.dto.request.CityRequestDto;
import uz.najottalim.jpapractise.dto.response.CityResponseDto;
import uz.najottalim.jpapractise.entity.City;
import uz.najottalim.jpapractise.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CityResponseDto>> getAll() {
        return cityService.findAll();
    }

    @GetMapping(value = "/one/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> deleteById(@PathVariable Long id) {
        return cityService.delete(id);
    }

    @PostMapping("/save")
    public ResponseEntity<CityResponseDto> deleteById(@RequestBody CityRequestDto cityRequestDto) {
        return ResponseEntity.ok(cityService.save(cityRequestDto));
    }


}
