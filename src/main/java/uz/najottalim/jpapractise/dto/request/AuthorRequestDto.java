package uz.najottalim.jpapractise.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorRequestDto {
    String fullName;
    Long cityId;
}
