package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.StringJoiner;

@Embeddable
public class EventoArtistaId {
    @Column(name = "evento_has_id")
    private Long eventoHasId;
    @Column(name = "artista_has_id")
    private Long artistaHasId;

    public EventoArtistaId(Long eventoHasId, Long artistaHasId) {
        this.eventoHasId = eventoHasId;
        this.artistaHasId = artistaHasId;
    }

    public EventoArtistaId() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EventoArtistaId.class.getSimpleName() + "[", "]")
                .add("eventoHasId=" + eventoHasId)
                .add("artistaHasId=" + artistaHasId)
                .toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        EventoArtistaId that = (EventoArtistaId) object;
        return Objects.equals(eventoHasId, that.eventoHasId) && Objects.equals(artistaHasId, that.artistaHasId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventoHasId, artistaHasId);
    }

    public Long getEventoHasId() {
        return eventoHasId;
    }

    public void setEventoHasId(Long eventoHasId) {
        this.eventoHasId = eventoHasId;
    }

    public Long getArtistaHasId() {
        return artistaHasId;
    }

    public void setArtistaHasId(Long artistaHasId) {
        this.artistaHasId = artistaHasId;
    }
}
