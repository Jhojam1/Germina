package com.Germina.Germina.persistence.repositories;

import com.Germina.Germina.persistence.entities.ConfigHr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigHrRepository extends JpaRepository<ConfigHr, Long> {
    Optional<ConfigHr> findById(String id);
}
