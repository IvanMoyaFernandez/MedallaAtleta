package com.medallaAtleta.Repository;

import com.medallaAtleta.Entity.Atleta;
import com.medallaAtleta.Entity.Medalla;
import com.medallaAtleta.Entity.TipoMedalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Long> {
    public List<Atleta> findByNombre(String nombreAtleta);

    // 1. Devolver todos los Atletas de una nacionalidad determinada
    List<Atleta> findByNacionalidadLike(String nacionalidad);

    // 2. Devolver todos los atletas que hayan nacido en una fecha anterior a una fecha determinada.
    List<Atleta> findByfechaNacimientoLessThan(Date fechaNacimiento);

    // 3. Devolver todos los atletas que hayan nacido en una fecha anterior a una fecha determinada.
    @Query("SELECT atleta " +
            "FROM Atleta atleta")
    List<Atleta> getAtletasGroupByNacionalidad();
}
