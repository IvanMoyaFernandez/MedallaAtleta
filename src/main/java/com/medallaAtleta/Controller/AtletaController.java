package com.medallaAtleta.Controller;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.medallaAtleta.Entity.Atleta;
import com.medallaAtleta.Entity.Medalla;
import com.medallaAtleta.Entity.TipoMedalla;
import com.medallaAtleta.Repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atleta createPlayer(@RequestBody Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    // PUT
    @PutMapping
    public Atleta updatePlayer(@RequestBody Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    // GET TODOS LOS ATLETAS
    @GetMapping
    public List<Atleta> findAll() {
        return atletaRepository.findAll();
    }

    // GET UN ATLETA
    @GetMapping("/{id}")
    public Atleta findById(@PathVariable Long id) {
        Atleta atleta = atletaRepository.findOne(id);
        return atleta;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteAtleta(@PathVariable Long id) {atletaRepository.delete(id);}

// 1. Retornar todos los atletas agrupados por nacionalidad mediante un Map<String, List<Atleta>>;
    @GetMapping("/groupByNacionalidad")
    public Map<String, Collection<Atleta>> getAtletasGroupByNacionalidad() {
        //  Creamos el multimap - MultiMapAtletas - que contendrá una key que en nuestro caso
        // será la nacionalidad del atleta y también contendrá unos valores que en nuestro caso
        // serán todos los datos del atleta.
        ListMultimap<String, Atleta> MultiMapAtletas = ArrayListMultimap.create();
        //  auxiliar es un array de atletas, guarda el resultado de la query
        //  getAtletasGroupByNacionalidad que está en de AtletaRepository
        List<Atleta> auxiliar = atletaRepository.getAtletasGroupByNacionalidad();
        // Por cada veulta del for recorre el array del atleta de esa posición
        // que hay dentro del array -auxiliar-
        for (Atleta atleta : auxiliar ) {
            //  Al multimap - MultiMapAtletas - le añadimos como key la nacionalidad del atleta
            //  y como valores todos los valores restantes del atleta.
            MultiMapAtletas.put(atleta.getNacionalidad(), atleta);
        }
        //  Devolvemos un multimap convertido en map con todos los atletas agrupados por su key
        return MultiMapAtletas.asMap();
    }
//                      POR ACABAR
// 2. Retornar todos los atletas agrupados por tipo de medalla mediante un Map<TipoMedalla, List<Atleta>>
    /*@GetMapping("/groupByTipoMedalla")
    public Map<Medalla, Collection<Atleta>> getAtletasGroupByTipoMedalla() {
        ListMultimap<Medalla, Atleta> MultiMapAtletas2 = ArrayListMultimap.create();
        List<Atleta> auxiliar = atletaRepository.getAtletasGroupByTipoMedalla();
        for (Atleta at : auxiliar ) {
            MultiMapAtletas2.put(at.getMedalla(), at);
        }
        return MultiMapAtletas2.asMap();
    }*/
}

