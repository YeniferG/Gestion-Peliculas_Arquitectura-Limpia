package co.com.sofka.estreno.domain.estreno;


public final class Pelicula {

    private final String peliculaId;
    private final String titulo;
    private final String imagenURL;
    private final String anio;
    private final String duracion;
    private final String genero;
    private final String sipnosis;
    private final String videoURL;

    public Pelicula(String peliculaId, String titulo, String imagen, String anio, String duracion, String sipnosis, String genero, String videoURL) {
        this.peliculaId = peliculaId;
        this.titulo = titulo;
        this.imagenURL = imagen;
        this.anio = anio;
        this.duracion = duracion;
        this.sipnosis = sipnosis;
        this.genero = genero;
        this.videoURL = videoURL;
    }

    public String peliculaId() {
        return peliculaId;
    }

    public String imagenURL(){return imagenURL;}

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
