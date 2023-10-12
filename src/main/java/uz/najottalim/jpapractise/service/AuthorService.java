package uz.najottalim.jpapractise.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.jpapractise.dto.request.AuthorRequestDto;
import uz.najottalim.jpapractise.dto.response.AuthorResponseDto;
import uz.najottalim.jpapractise.entity.Author;
import uz.najottalim.jpapractise.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author findById(Long id) {
        Optional<Author> byId = authorRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new RuntimeException("Country topilmadi; id = " + id);
        }
    }

    public List<AuthorResponseDto> findAll() {
        return mapToDto(authorRepository.findAll());
    }

    public ResponseEntity<AuthorResponseDto> save(AuthorRequestDto dto) {
        Author author = mapToEntity(dto);
        AuthorResponseDto authorResponseDto = mapToDto(authorRepository.save(author));
        return ResponseEntity.ok(authorResponseDto);
    }

    public ResponseEntity<AuthorResponseDto> save(Author author) {
        AuthorResponseDto authorResponseDto = mapToDto(authorRepository.save(author));
        return ResponseEntity.ok(authorResponseDto);
    }

    public ResponseEntity<Author> delete(Long id) {
        authorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Author mapToEntity(AuthorRequestDto dto) {
        Author author = new Author();
        author.setFullName(dto.getFullName());
        return author;
    }

    public List<AuthorResponseDto> mapToDto(List<Author> author) {
        return author.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public AuthorResponseDto mapToDto(Author author) {
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setFullName(author.getFullName());
        dto.setId(author.getId());
        return dto;
    }
}