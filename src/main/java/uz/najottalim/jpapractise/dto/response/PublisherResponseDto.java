package uz.najottalim.jpapractise.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PublisherResponseDto {
    Long id;
    String name;
    Long cityId;
}