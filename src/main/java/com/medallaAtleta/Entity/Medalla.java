package com.medallaAtleta.Entity;

import javax.persistence.*;

@Entity
public class Medalla {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoMedalla tipoMedalla;

    @Column
    public String especialidad;

    @Column
    public String competicion;

    // una medalla solo pertenecerá a un atleta
    // esta es la fuerte (la debil está en Atleta.java)
    @ManyToOne
    private Atleta atleta;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public TipoMedalla getTipoMedalla() {
        return tipoMedalla;
    }
    public void setTipoMedalla(TipoMedalla tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCompeticion() {
        return competicion;
    }
    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Atleta getAtleta() {return atleta;}
    public void setAtleta(Atleta atleta) {this.atleta = atleta;}



    @Override
    public String toString() {
        return "Medalla{" +
                "id=" + id +
                ", tipoMedalla=" + tipoMedalla +
                ", especialidad='" + especialidad + '\'' +
                ", competicion='" + competicion + '\'' +
                ", atleta=" + atleta +
                '}';
    }
}
