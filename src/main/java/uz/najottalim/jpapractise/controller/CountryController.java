package uz.najottalim.jpapractise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.jpapractise.dto.request.CountryRequestDto;
import uz.najottalim.jpapractise.dto.response.CountryResponseDto;
import uz.najottalim.jpapractise.entity.Country;
import uz.najottalim.jpapractise.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CountryResponseDto>> getAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Country> getById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> deleteById(@PathVariable Long id) {
        return countryService.delete(id);
    }

    @PostMapping("/save")
    public ResponseEntity<CountryResponseDto> save(@RequestBody CountryRequestDto countryRequestDto) {
        return countryService.save(countryRequestDto);
    }


}
