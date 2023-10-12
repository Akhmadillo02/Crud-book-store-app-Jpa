package uz.najottalim.jpapractise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.jpapractise.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {


}
