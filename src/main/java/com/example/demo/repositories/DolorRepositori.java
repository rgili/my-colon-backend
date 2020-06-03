package com.example.demo.repositories;

import com.example.demo.domain.registreSimptomes.Dolor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DolorRepositori extends JpaRepository<Dolor, Integer> {
    List<Dolor> findAllByUsuari(@Param("usuari") Integer usuari);
}
