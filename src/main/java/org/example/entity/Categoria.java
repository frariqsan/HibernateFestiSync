package org.example.entity;

import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Categoria.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nombre='" + nombre + "'")
                .add("evento=" + evento)
                .toString();
    }
}
