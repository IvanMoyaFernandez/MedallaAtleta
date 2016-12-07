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

import java.util.List;
import java.util.Map;
import java.util.Collection;
import static java.util.stream.Collectors.groupingBy;



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
        // Por cada vuelta del for recorre el array del atleta de esa posición
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
    @GetMapping("/groupByTipoMedalla")
    public Map<TipoMedalla, List<Atleta>> getAtletasGroupByTipoMedalla(){
        return atletaRepository
                // Buscamos todos los atletas
                .findAll()
                // Trabajamos con ellos en paralelo
                .parallelStream()
                // Los agrupamos por el tipo de me dalla, para ello creamos un lambda -- medalla -> medalla.getTipoMedalla() == TipoMedalla.ORO --
                // que será recorrido por el 'bucle' anyMatch --> Si encuentra uno será true y devolvera el return,
                // sino pasará a la siguiente sentencia.
                // Así conseguimos almacenar como KEY el tipo de medalla y como VALUE el objeto jugador, así los atletas
                // podrán ser ordenados por su KEY, en este caso tipoMedallas.
                .collect(groupingBy(atleta -> {
                    if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.ORO)){
                        return TipoMedalla.ORO;
                    }else if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.PLATA)){
                        return TipoMedalla.PLATA;
                    }else if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.BRONZE)){
                        return TipoMedalla.BRONZE;
                    }else {
                        return TipoMedalla.NOMEDALLA;
                    }
                }));
    }
}