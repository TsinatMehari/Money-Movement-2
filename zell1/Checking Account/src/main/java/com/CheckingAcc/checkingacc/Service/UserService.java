package com.CheckingAcc.checkingacc.Service;

import com.CheckingAcc.checkingacc.DTO.UserDto;
import com.CheckingAcc.checkingacc.Entity.User;
import com.CheckingAcc.checkingacc.Exception.UserException;
import com.CheckingAcc.checkingacc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
       user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setActive(true);
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException.UserNotFoundException("User not found with id " + id));
    }
}
