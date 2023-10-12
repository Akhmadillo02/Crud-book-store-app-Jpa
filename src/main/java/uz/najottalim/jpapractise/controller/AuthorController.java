package uz.najottalim.jpapractise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.jpapractise.dto.request.AuthorRequestDto;
import uz.najottalim.jpapractise.dto.response.AuthorResponseDto;
import uz.najottalim.jpapractise.entity.Author;
import uz.najottalim.jpapractise.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorResponseDto>> getAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.delete(id).getBody());
    }

    @PostMapping("/save")
    public ResponseEntity<AuthorResponseDto> deleteById(@RequestBody AuthorRequestDto authorRequestDto) {
        return ResponseEntity.ok(authorService.save(authorRequestDto).getBody());
    }


}
