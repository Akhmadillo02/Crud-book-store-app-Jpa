package uz.najottalim.jpapractise.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.jpapractise.dto.request.CountryRequestDto;
import uz.najottalim.jpapractise.dto.response.CountryResponseDto;
import uz.najottalim.jpapractise.entity.Country;
import uz.najottalim.jpapractise.repository.CountryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country findById(Long id) {
        Optional<Country> byId = countryRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new RuntimeException("Country topilmadi; id = " + id);
        }
    }

    public List<CountryResponseDto> findAll() {
        return mapToDto(countryRepository.findAll());
    }

    public ResponseEntity<CountryResponseDto> save(CountryRequestDto dto) {
        Country country = mapToEntity(dto);
        CountryResponseDto countryResponseDto = mapToDto(countryRepository.save(country));
        return ResponseEntity.ok(countryResponseDto);
    }

    public ResponseEntity<CountryResponseDto> save(Country country) {
        CountryResponseDto countryResponseDto = mapToDto(countryRepository.save(country));
        return ResponseEntity.ok(countryResponseDto);
    }

    public ResponseEntity<Country> delete(Long id) {
        countryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Country mapToEntity(CountryRequestDto dto) {
        Country country = new Country();
        country.setName(dto.getName());
        return country;
    }

    public List<CountryResponseDto> mapToDto(List<Country> country) {
        return country.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public CountryResponseDto mapToDto(Country country) {
        CountryResponseDto dto = new CountryResponseDto();
        dto.setName(country.getName());
        dto.setId(country.getId());
        return dto;
    }
}