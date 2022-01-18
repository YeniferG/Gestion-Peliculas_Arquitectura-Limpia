package co.com.sofka.estreno.domain.estreno;

import co.com.sofka.estreno.domain.estreno.event.EstrenoCreated;
import co.com.sofka.estreno.domain.estreno.event.PeliculaAdded;
import co.com.sofka.estreno.domain.generic.AggregateRoot;
import co.com.sofka.estreno.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class Estreno extends AggregateRoot {

    protected String nombre;
    protected Map<String, Pelicula> peliculas;

    public Estreno(String id, String name){
        super(id);
        subscribe(new EstrenoEventChange(this));
        appendChange(new EstrenoCreated(id, name)).apply();
    }

    private Estreno(String id){
        super(id);
        subscribe(new EstrenoEventChange(this));
    }

    public static Estreno from(String estrenoId, List<DomainEvent> events) {
        var catalogo = new Estreno(estrenoId);
        events.forEach(catalogo::applyEvent);
        return catalogo;
    }

    public void addPelicula(String id, String titulo, String anio, String duracion, String sipnosis, String genero, String videoURL) {
        appendChange(new PeliculaAdded(id, titulo, anio, duracion, sipnosis, genero, videoURL)).apply();
    }

    public Pelicula findPeliculaById(String id) {
        return peliculas.get(id);
    }

    public Map<String, Pelicula> peliculas() {
        return peliculas;
    }

}
