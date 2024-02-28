package com.example.bankingapp.service;

import com.example.bankingapp.dto.UserDto;
import com.example.bankingapp.mappers.UserMapper;
import com.example.bankingapp.dto.Credentials;
import com.example.bankingapp.model.User;
import com.example.bankingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    public UserDto login(Credentials credentials) {
        User user = userRepository.findByUserName(credentials.userName()).orElseThrow(() -> new UsernameNotFoundException("No such username"));
        if (passwordEncoder.matches(CharBuffer.wrap(credentials.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new UsernameNotFoundException("No such username");
    }


}
