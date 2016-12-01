package com.medallaAtleta.Service;

import com.medallaAtleta.Entity.Atleta;
import com.medallaAtleta.Entity.Medalla;
import com.medallaAtleta.Repository.AtletaRepository;
import com.medallaAtleta.Repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

@Service
@Transactional
public class AtletaService {
    @Autowired
    private AtletaRepository atletaRepository;


    // CREAMOS LOS ATLETAS
    public void registrarAtletas() {
        Atleta atleta1 = new Atleta();
        atleta1.setNombre("Ivan");
        atleta1.setApellidos("Moya");
        atleta1.setFechaNacimiento(LocalDate.of(1995,8,11));
        atleta1.setNacionalidad("Es");
        atletaRepository.save(atleta1);
    }
}