package uz.najottalim.jpapractise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.jpapractise.dto.request.CityRequestDto;
import uz.najottalim.jpapractise.dto.response.CityResponseDto;
import uz.najottalim.jpapractise.entity.City;
import uz.najottalim.jpapractise.entity.Country;
import uz.najottalim.jpapractise.repository.CityRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private CountryService countryService;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public ResponseEntity<City> findById(Long id) {
        Optional<City> byId = cityRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<CityResponseDto>> findAll() {
        return ResponseEntity.ok(mapToDto(cityRepository.findAll()));
    }

    public CityResponseDto save(CityRequestDto cityRequestDto) {
        City city = mapToEntity(cityRequestDto);

        Country byId = countryService.findById(cityRequestDto.getCountryId());
        city.setCountry(byId);
        byId.addCities(city);


        cityRepository.save(city);
        countryService.save(byId);

        CityResponseDto responseDto = mapToDto(city);

        return responseDto;
    }

    public ResponseEntity<City> delete(Long id) {
        cityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }


    public List<CityResponseDto> mapToDto(List<City> cities) {
        return cities.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private City mapToEntity(CityRequestDto dto) {
        City city = new City();
        city.setName(dto.getName());
        return city;
    }


    public CityResponseDto mapToDto(City city) {
        CityResponseDto dto = new CityResponseDto();
        dto.setName(city.getName());
        dto.setId(city.getId());
        dto.setCountryId(city.getCountry().getId());
        return dto;
    }


}
