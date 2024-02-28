package com.example.bankingapp.mappers;

import com.example.bankingapp.dto.UserDto;
import com.example.bankingapp.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Mapper(componentModel = "spring")
@Component
public interface UserMapper {


    UserDto toUserDto(User user);
}
