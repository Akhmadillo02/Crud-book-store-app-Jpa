package uz.najottalim.jpapractise.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseDto {
    Long id;
    String name;
    Long authorId;
    Long publisherId;
    List<Long> tags;
}