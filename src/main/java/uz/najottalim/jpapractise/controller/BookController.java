package uz.najottalim.jpapractise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.jpapractise.dto.request.BookRequestDto;
import uz.najottalim.jpapractise.dto.response.BookResponseDto;
import uz.najottalim.jpapractise.entity.Book;
import uz.najottalim.jpapractise.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookResponseDto>> getAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.delete(id).getBody());
    }

    @PostMapping("/save")
    public ResponseEntity<BookResponseDto> deleteById(@RequestBody BookRequestDto BookRequestDto) {
        return ResponseEntity.ok(bookService.save(BookRequestDto).getBody());
    }


}
