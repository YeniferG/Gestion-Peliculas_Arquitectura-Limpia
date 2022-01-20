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
        var estreno = new Estreno(estrenoId);
        events.forEach(estreno::applyEvent);
        return estreno;
    }

    public void addPelicula(String peliculaId, String titulo, String anio, String duracion, String genero, String sipnosis, String videoURL) {
        appendChange(new PeliculaAdded(peliculaId, titulo, anio, duracion, genero, sipnosis, videoURL)).apply();
    }

    public Pelicula findPeliculaById(String id) {
        return peliculas.get(id);
    }

    public Map<String, Pelicula> peliculas() {
        return peliculas;
    }

}
