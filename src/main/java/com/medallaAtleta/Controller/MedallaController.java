package com.medallaAtleta.Controller;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.medallaAtleta.Entity.Atleta;
import com.medallaAtleta.Entity.Medalla;
import com.medallaAtleta.Repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medallas")
public class MedallaController {

    @Autowired
    private MedallaRepository medallaRepository;

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medalla createPlayer(@RequestBody Medalla medalla) {
        return medallaRepository.save(medalla);
    }

    // PUT
    @PutMapping
    public Medalla updatePlayer(@RequestBody Medalla medalla) {
        return medallaRepository.save(medalla);
    }

    // GET TODAS LAS MEDALLAS
    @GetMapping
    public List<Medalla> findAll() {
        return medallaRepository.findAll();
    }

    // GET UNA MEDALLA
    @GetMapping("/{id}")
    public Medalla findById(@PathVariable Long id) {
        Medalla medalla = medallaRepository.findOne(id);
        return medalla;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteMedalla(@PathVariable Long id) {medallaRepository.delete(id);}
}