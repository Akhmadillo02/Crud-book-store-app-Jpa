package uz.najottalim.jpapractise.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorResponseDto {
    Long id;
    String fullName;
    Long cityId;
}