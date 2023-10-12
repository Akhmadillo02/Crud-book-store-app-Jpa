package uz.najottalim.jpapractise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.jpapractise.entity.Author;
import uz.najottalim.jpapractise.entity.Publisher;

public interface AuthorRepository extends JpaRepository<Author, Long> {


}
