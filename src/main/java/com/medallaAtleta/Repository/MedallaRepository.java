package com.medallaAtleta.Repository;

import com.medallaAtleta.Entity.Medalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MedallaRepository extends JpaRepository<Medalla, Long> {
    @Query("SELECT medalla " +
            "FROM Medalla medalla")
    List<Medalla> getAtletasGroupByTipoMedalla();
}

