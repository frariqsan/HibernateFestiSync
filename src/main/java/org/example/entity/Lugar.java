package org.example.entity;

import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Table(name = "lugar")
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lugar")
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String ciudad;
    @Column(nullable = true)
    private Integer aforo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
