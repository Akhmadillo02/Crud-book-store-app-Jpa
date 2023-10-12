package uz.najottalim.jpapractise.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.jpapractise.dto.request.PublisherRequestDto;
import uz.najottalim.jpapractise.dto.response.PublisherResponseDto;
import uz.najottalim.jpapractise.entity.Publisher;
import uz.najottalim.jpapractise.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher findById(Long id) {
        Optional<Publisher> byId = publisherRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new RuntimeException("Publisher topilmadi; id = " + id);
        }
    }

    public List<PublisherResponseDto> findAll() {
        return mapToDto(publisherRepository.findAll());
    }

    public ResponseEntity<PublisherResponseDto> save(PublisherRequestDto dto) {
        Publisher publisher = mapToEntity(dto);
        PublisherResponseDto publisherResponseDto = mapToDto(publisherRepository.save(publisher));
        return ResponseEntity.ok(publisherResponseDto);
    }

    public ResponseEntity<PublisherResponseDto> save(Publisher publisher) {
        PublisherResponseDto publisherResponseDto = mapToDto(publisherRepository.save(publisher));
        return ResponseEntity.ok(publisherResponseDto);
    }

    public ResponseEntity<Publisher> delete(Long id) {
        publisherRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Publisher mapToEntity(PublisherRequestDto dto) {
        Publisher publisher = new Publisher();
        publisher.setName(dto.getName());

        return publisher;
    }

    public List<PublisherResponseDto> mapToDto(List<Publisher> publisher) {
        return publisher.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public PublisherResponseDto mapToDto(Publisher publisher) {
        PublisherResponseDto dto = new PublisherResponseDto();
        dto.setName(publisher.getName());
        dto.setId(publisher.getId());
        return dto;
    }
}