package uz.najottalim.jpapractise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.jpapractise.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}