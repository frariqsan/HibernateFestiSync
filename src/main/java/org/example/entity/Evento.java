package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Long id;
    @Column(nullable = false, name = "nombre")
    private String nombre;
    @Column(nullable = false, name = "fecha")
    private LocalDate fecha;
    //falta lugar_id
    @ManyToOne
    @JoinColumn(name = "id_lugar", nullable = false)
    private Lugar lugar;

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Evento.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nombre='" + nombre + "'")
                .add("fecha=" + fecha)
                .add("lugar=" + lugar)
                .toString();
    }
}
