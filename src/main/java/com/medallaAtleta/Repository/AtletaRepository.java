package com.medallaAtleta.Repository;

import com.medallaAtleta.Entity.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Long> {
    public List<Atleta> findByNombre(String nombreAtleta);

    // 1. Retornar todos los atletas agrupados por nacionalidad mediante un Map<String, List<Atleta>>;
    @Query("SELECT atleta " +
            "FROM Atleta atleta")
    List<Atleta> getAtletasGroupByNacionalidad();

//                      POR ACABAR
    // 2. Retornar todos los atletas agrupados por tipo de medalla mediante un Map<TipoMedalla, List<Atleta>>
    @Query("SELECT atleta " +
            "FROM Atleta atleta")
    List<Atleta> getAtletasGroupByTipoMedalla();
}
