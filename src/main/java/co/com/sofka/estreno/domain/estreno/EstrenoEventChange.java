package co.com.sofka.estreno.domain.estreno;

import co.com.sofka.estreno.domain.estreno.event.EstrenoCreated;
import co.com.sofka.estreno.domain.estreno.event.PeliculaAdded;
import co.com.sofka.estreno.domain.generic.EventChange;

import java.util.HashMap;
import java.util.Objects;

public class EstrenoEventChange implements EventChange {

    protected EstrenoEventChange(Estreno estreno){
        listener((EstrenoCreated event) -> {
            estreno.nombre = Objects.requireNonNull(event.getNombre());
            estreno.peliculas = new HashMap<>();
        });
        listener((PeliculaAdded event) -> {
            estreno.peliculas.put(event.getPeliculaId(), new Pelicula(event.getPeliculaId(), event.getTitulo(), event.getAnio(), event.getDuracion(), event.getSipnosis(), event.getGenero(), event.getVideoURL()));
        });
    }

}
