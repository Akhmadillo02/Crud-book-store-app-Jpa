package uz.najottalim.jpapractise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.jpapractise.entity.Author;
import uz.najottalim.jpapractise.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {


}
