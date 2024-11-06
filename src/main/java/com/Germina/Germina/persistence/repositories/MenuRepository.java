package com.Germina.Germina.persistence.repositories;

import com.Germina.Germina.persistence.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
