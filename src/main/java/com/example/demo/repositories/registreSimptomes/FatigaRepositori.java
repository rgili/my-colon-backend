package com.example.demo.repositories.registreSimptomes;

import com.example.demo.domain.registreSimptomes.Fatiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FatigaRepositori extends JpaRepository<Fatiga, Integer> {
    List<Fatiga> findAllByUsuariOrderByDataDesc(@Param("usuari") Integer usuari);
}
