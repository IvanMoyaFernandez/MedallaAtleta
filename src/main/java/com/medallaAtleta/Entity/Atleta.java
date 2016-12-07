package com.medallaAtleta.Entity;

import com.medallaAtleta.Entity.Medalla;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Atleta{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long id;

    @Column
    public String nombre;

    @Column
    public String apellidos;

    @Column
    public String nacionalidad;

    @Column
    public LocalDate fechaNacimiento;

    // un atleta tendrá muchas medallas
    // esta es la debil (la fuerte está en Medalla.java)
    @JsonIgnore
    @OneToMany(mappedBy = "atleta")
    private Set<Medalla> medallas = new HashSet<>();

    public Atleta() {}

    public Atleta(String nombre, String apellidos, String nacionalidad, LocalDate cumple) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = cumple;
    }


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public String getNacionalidad() {return nacionalidad;}
    public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}

    public LocalDate getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public Set<Medalla> getMedallas() {return medallas;}
    public void setMedallas(Set<Medalla> medalla) {this.medallas = medalla;}


    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}