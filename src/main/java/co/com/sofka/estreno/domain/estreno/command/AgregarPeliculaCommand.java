package co.com.sofka.estreno.domain.estreno.command;

import co.com.sofka.estreno.domain.generic.Command;

public class AgregarPeliculaCommand extends Command {

    private String estrenoId;
    private String peliculaId;
    private String imagenURL;
    private String titulo;
    private String anio;
    private String duracion;
    private String genero;
    private String sipnosis;
    private String videoURL;

    public AgregarPeliculaCommand(){}

    public String getEstrenoId() {
        return estrenoId;
    }

    public void setEstrenoId(String estrenoId) {
        this.estrenoId = estrenoId;
    }

    public String getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(String peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
