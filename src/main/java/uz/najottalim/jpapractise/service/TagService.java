package uz.najottalim.jpapractise.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.jpapractise.dto.request.TagRequestDto;
import uz.najottalim.jpapractise.dto.response.TagResponseDto;
import uz.najottalim.jpapractise.entity.Tag;
import uz.najottalim.jpapractise.repository.TagRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag findById(Long id) {
        Optional<Tag> byId = tagRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new RuntimeException("Tag topilmadi; id = " + id);
        }
    }

    public List<TagResponseDto> findAll() {
        return mapToDto(tagRepository.findAll());
    }

    public ResponseEntity<TagResponseDto> save(TagRequestDto dto) {
        Tag tag = mapToEntity(dto);
        TagResponseDto tagResponseDto = mapToDto(tagRepository.save(tag));
        return ResponseEntity.ok(tagResponseDto);
    }

    public ResponseEntity<TagResponseDto> save(Tag tag) {
        TagResponseDto tagResponseDto = mapToDto(tagRepository.save(tag));
        return ResponseEntity.ok(tagResponseDto);
    }

    public ResponseEntity<Tag> delete(Long id) {
        tagRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Tag mapToEntity(TagRequestDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());

        return tag;
    }

    public List<TagResponseDto> mapToDto(List<Tag> tag) {
        return tag.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public TagResponseDto mapToDto(Tag tag) {
        TagResponseDto dto = new TagResponseDto();
        dto.setName(tag.getName());
        dto.setId(tag.getId());
        return dto;
    }
}