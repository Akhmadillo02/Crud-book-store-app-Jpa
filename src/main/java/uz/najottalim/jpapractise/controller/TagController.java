package uz.najottalim.jpapractise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.jpapractise.dto.request.TagRequestDto;
import uz.najottalim.jpapractise.dto.response.TagResponseDto;
import uz.najottalim.jpapractise.entity.Tag;
import uz.najottalim.jpapractise.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TagResponseDto>> getAll() {
        return ResponseEntity.ok(tagService.findAll());
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Tag> getById(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tag> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.delete(id).getBody());
    }

    @PostMapping("/save")
    public ResponseEntity<TagResponseDto> deleteById(@RequestBody TagRequestDto tagRequestDto) {
        return ResponseEntity.ok(tagService.save(tagRequestDto).getBody());
    }


}
