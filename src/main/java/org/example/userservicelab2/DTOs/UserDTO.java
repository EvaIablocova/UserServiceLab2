package org.example.userservicelab2.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.example.userservicelab2.models.User;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
