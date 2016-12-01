package com.medallaAtleta.Service;

import com.medallaAtleta.Entity.Atleta;
import com.medallaAtleta.Entity.Medalla;
import com.medallaAtleta.Entity.TipoMedalla;
import com.medallaAtleta.Repository.AtletaRepository;
import com.medallaAtleta.Repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedallaService {
    @Autowired
    private MedallaRepository medallaRepository;
    @Autowired
    private AtletaRepository atletaRepository;

    // CREAMOS LAS MEDALLAS
    public void registrarMedallas() {
        Atleta atleta;
        Medalla medalla1 = new Medalla();
        medalla1.setTipoMedalla(TipoMedalla.BRONZE);
        medalla1.setEspecialidad("Masculino");
        medalla1.setCompeticion("Basquet");
        atleta = atletaRepository.findByNombre("Ivan").get(0);
        medalla1.setAtleta(atleta);
        medallaRepository.save(medalla1);
    }
}