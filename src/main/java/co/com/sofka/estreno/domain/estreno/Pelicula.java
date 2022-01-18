package co.com.sofka.estreno.domain.estreno;

import java.util.Objects;

public final class Pelicula {

    private final String id;
    private final String titulo;
    private final String anio;
    private final String duracion;
    private final String genero;
    private final String sipnosis;
    private final String videoURL;

    public Pelicula(String id, String titulo, String anio, String duracion, String sipnosis, String genero, String videoURL) {
        this.id = Objects.requireNonNull(id);
        this.titulo = Objects.requireNonNull(titulo);
        this.anio = Objects.requireNonNull(anio);
        this.duracion = Objects.requireNonNull(duracion);
        this.sipnosis = Objects.requireNonNull(sipnosis);
        this.genero = Objects.requireNonNull(genero);
        this.videoURL = Objects.requireNonNull(videoURL);
    }

    public String id() {
        return id;
    }

    public String titulo() {
        return titulo;
    }

    public String anio() {
        return anio;
    }

    public String duracion() {
        return duracion;
    }

    public String sipnosis() {
        return sipnosis;
    }

    public String genero() {
        return genero;
    }

    public String videoURL() {
        return videoURL;
    }

}
