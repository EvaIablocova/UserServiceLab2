package org.example.userservicelab2.services;

import org.example.userservicelab2.DTOs.UserDTO;
import org.example.userservicelab2.models.User;
import org.example.userservicelab2.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<UserDTO> getAllUsers() {
        Long count = userRepository.count();

        List<User> list = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : list) {
            UserDTO userDTO = new UserDTO(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    public UserDTO getUserById(Long id) {
        return new UserDTO(userRepository.findById(id).orElse(null));
    }

    public UserDTO createUser(UserDTO userDTO) {
        return new UserDTO(userRepository.save(new User(userDTO)));
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        userDTO.setId(id);
        return new UserDTO(userRepository.save(new User(userDTO)));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
