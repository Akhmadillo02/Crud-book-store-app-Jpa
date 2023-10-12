package uz.najottalim.jpapractise.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequestDto {
    String name;
    Long authorId;
    Long publisherId;
    List<Long> tags;
}
