package org.example.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "evento_has_artista")
public class EventoArtista {
    @EmbeddedId
    private EventoArtistaId id;

    @ManyToOne
    @MapsId("eventoHasId")
    @JoinColumn(name = "evento_has_id")
    private Evento evento;
    @ManyToOne
    @MapsId("artistaHasId")
    @JoinColumn(name = "artista_has_id")
    private Artista artista;

    public EventoArtistaId getId() {
        return id;
    }

    public void setId(EventoArtistaId id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        EventoArtista that = (EventoArtista) object;
        return Objects.equals(id, that.id) && Objects.equals(evento, that.evento) && Objects.equals(artista, that.artista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, evento, artista);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EventoArtista.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("evento=" + evento)
                .add("artista=" + artista)
                .toString();
    }

}
