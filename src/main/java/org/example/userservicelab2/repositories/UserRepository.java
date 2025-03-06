package org.example.userservicelab2.repositories;

import org.example.userservicelab2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

