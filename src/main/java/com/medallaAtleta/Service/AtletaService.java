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

        Atleta atleta2 = new Atleta();
        atleta2.setNombre("Carlos");
        atleta2.setApellidos("Garcia");
        atleta2.setFechaNacimiento(LocalDate.of(1993,4,20));
        atleta2.setNacionalidad("Por");
        atletaRepository.save(atleta2);

        Atleta atleta3 = new Atleta();
        atleta3.setNombre("Jose");
        atleta3.setApellidos("Dorado");
        atleta3.setFechaNacimiento(LocalDate.of(1994,11,5));
        atleta3.setNacionalidad("Es");
        atletaRepository.save(atleta3);

        Atleta atleta4 = new Atleta();
        atleta4.setNombre("Pepe");
        atleta4.setApellidos("Fernandez");
        atleta4.setFechaNacimiento(LocalDate.of(1994,7,7));
        atleta4.setNacionalidad("Por");
        atletaRepository.save(atleta4);
    }
}