package co.com.sofka.estreno.domain.estreno.event;

import co.com.sofka.estreno.domain.generic.DomainEvent;

public class PeliculaAdded extends DomainEvent {

    private final String peliculaId;
    private final String titulo;
    private final String anio;
    private final String duracion;
    private final String sipnosis;
    private final String genero;
    private final String videoURL;

    public PeliculaAdded(String peliculaId, String titulo, String anio, String duracion, String sipnosis, String genero, String videoURL) {
        super("sofka.estreno.peliculaadded");
        this.peliculaId = peliculaId;
        this.titulo = titulo;
        this.anio = anio;
        this.duracion = duracion;
        this.sipnosis = sipnosis;
        this.genero = genero;
        this.videoURL = videoURL;
    }

    public String getPeliculaId() {
        return peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAnio() {
        return anio;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public String getGenero() {
        return genero;
    }

    public String getVideoURL() {
        return videoURL;
    }
}
