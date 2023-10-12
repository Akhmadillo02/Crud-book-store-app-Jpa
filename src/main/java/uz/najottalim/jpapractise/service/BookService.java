package uz.najottalim.jpapractise.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.jpapractise.dto.request.BookRequestDto;
import uz.najottalim.jpapractise.dto.response.BookResponseDto;
import uz.najottalim.jpapractise.entity.Book;
import uz.najottalim.jpapractise.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new RuntimeException("Book topilmadi; id = " + id);
        }
    }

    public List<BookResponseDto> findAll() {
        return mapToDto(bookRepository.findAll());
    }

    public ResponseEntity<BookResponseDto> save(BookRequestDto dto) {
        Book book = mapToEntity(dto);
        BookResponseDto bookResponseDto = mapToDto(bookRepository.save(book));
        return ResponseEntity.ok(bookResponseDto);
    }

    public ResponseEntity<BookResponseDto> save(Book book) {
        BookResponseDto bookResponseDto = mapToDto(bookRepository.save(book));
        return ResponseEntity.ok(bookResponseDto);
    }

    public ResponseEntity<Book> delete(Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Book mapToEntity(BookRequestDto dto) {
        Book book = new Book();
        book.setName(dto.getName());

        return book;
    }

    public List<BookResponseDto> mapToDto(List<Book> book) {
        return book.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public BookResponseDto mapToDto(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setName(book.getName());
        return dto;
    }
}