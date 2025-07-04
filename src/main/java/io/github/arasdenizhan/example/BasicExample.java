package io.github.arasdenizhan.example;

import io.github.arasdenizhan.core.validator.impl.SlimValidator;
import io.github.arasdenizhan.example.dto.UserDto;

public class BasicExample {
    public static void main(String[] args) {
        SlimValidator validator = new SlimValidator();
        UserDto userDto = new UserDto();
        userDto.setAge(12);
        userDto.setCountryCode(5);
        userDto.setEmail("email");
        validator.validate(userDto);
    }
}
