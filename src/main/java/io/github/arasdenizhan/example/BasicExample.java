package io.github.arasdenizhan.example;

import io.github.arasdenizhan.core.validator.impl.SlimValidator;
import io.github.arasdenizhan.example.dto.UserDto;

import java.time.LocalDate;

public class BasicExample {
    public static void main(String[] args) {
        SlimValidator validator = new SlimValidator();
        UserDto userDto = new UserDto();
        userDto.setAge(12);
        userDto.setCountryCode(5);
        userDto.setEmail("email");
        userDto.setPastDate(LocalDate.of(1981,1,1));
        userDto.setFutureDate(LocalDate.of(2035,2,2));
        validator.validate(userDto);
    }
}
