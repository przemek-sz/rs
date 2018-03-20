package com.szczerbap.rssreader.service;

import com.szczerbap.rssreader.data.dto.AllUserDto;
import com.szczerbap.rssreader.data.dto.UserRegistrationDto;
import com.szczerbap.rssreader.model.User;
import com.szczerbap.rssreader.repository.UserRepository;
import com.szczerbap.rssreader.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    BaseConverter<User, AllUserDto> baseConverter;
    @Autowired
    BaseConverter<UserRegistrationDto,User> registrationBaseConverter;

    @Override
    public void addUser(UserRegistrationDto userDto) {

        String DEFAULT_ROLE="ROLE_USER";

        User user=new User();

        user=registrationBaseConverter.convert(userDto);
        user.getRoles().add(userRoleRepository.getByRole(DEFAULT_ROLE));

        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<AllUserDto> getAllUsers() {

        List<AllUserDto> usersDto=baseConverter.convertAll(userRepository.findAll());
        return usersDto;
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.getByUserName(username);
    }
}
