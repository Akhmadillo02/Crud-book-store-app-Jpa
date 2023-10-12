package uz.najottalim.jpapractise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.jpapractise.dto.request.PublisherRequestDto;
import uz.najottalim.jpapractise.dto.response.PublisherResponseDto;
import uz.najottalim.jpapractise.entity.Publisher;
import uz.najottalim.jpapractise.service.PublisherService;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PublisherResponseDto>> getAll() {
        return ResponseEntity.ok(publisherService.findAll());
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Publisher> getById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Publisher> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.delete(id).getBody());
    }

    @PostMapping("/save")
    public ResponseEntity<PublisherResponseDto> deleteById(@RequestBody PublisherRequestDto publisherRequestDto) {
        return ResponseEntity.ok(publisherService.save(publisherRequestDto).getBody());
    }


}
