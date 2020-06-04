package com.example.demo.repositories.registreSimptomes;

import com.example.demo.domain.registreSimptomes.Diarrees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiarreesRepositori extends JpaRepository<Diarrees, Integer> {
    List<Diarrees> findAllByUsuariOrderByDataDesc(@Param("usuari") Integer usuari);
}
