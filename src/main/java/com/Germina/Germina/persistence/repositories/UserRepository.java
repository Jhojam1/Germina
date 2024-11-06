package com.Germina.Germina.persistence.repositories;

import com.Germina.Germina.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
