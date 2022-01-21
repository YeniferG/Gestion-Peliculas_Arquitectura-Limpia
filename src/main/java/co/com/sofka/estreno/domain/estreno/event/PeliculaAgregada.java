package co.com.sofka.estreno.domain.estreno.event;

import co.com.sofka.estreno.domain.generic.DomainEvent;

public class PeliculaAgregada extends DomainEvent {

    private final String peliculaId;
    private final String titulo;
    private final String imagenURL;
    private final String anio;
    private final String duracion;
    private final String genero;
    private final String sipnosis;
    private final String videoURL;

    public PeliculaAgregada(String peliculaId, String titulo, String imagenURL, String anio, String duracion, String genero, String sipnosis, String videoURL) {
        super("sofka.estreno.peliculaagregada");
        this.peliculaId = peliculaId;
        this.titulo = titulo;
        this.imagenURL = imagenURL;
        this.anio = anio;
        this.duracion = duracion;
        this.genero = genero;
        this.sipnosis = sipnosis;
        this.videoURL = videoURL;
    }

    public String getPeliculaId() {
        return peliculaId;
    }

    public String getImagenURL() {
        return imagenURL;
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

    public String getGenero() {
        return genero;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public String getVideoURL() {
        return videoURL;
    }
}
