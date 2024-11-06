package com.Germina.Germina.persistence.repositories;

import com.Germina.Germina.persistence.entities.TempUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempUserRepository extends JpaRepository<TempUser, Long> {
}
