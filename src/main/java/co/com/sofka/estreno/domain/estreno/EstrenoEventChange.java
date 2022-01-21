package co.com.sofka.estreno.domain.estreno;

import co.com.sofka.estreno.domain.estreno.event.EstrenoCreado;
import co.com.sofka.estreno.domain.estreno.event.PeliculaAgregada;
import co.com.sofka.estreno.domain.generic.EventChange;

import java.util.HashMap;
import java.util.Objects;

public class EstrenoEventChange implements EventChange {

    protected EstrenoEventChange(Estreno estreno){
        listener((EstrenoCreado event) -> {
            estreno.nombre = Objects.requireNonNull(event.getNombre());
            estreno.peliculas = new HashMap<>();
        });
        listener((PeliculaAgregada event) -> {
            estreno.peliculas.put(event.getPeliculaId(), new Pelicula(event.getPeliculaId(), event.getTitulo(), event.getImagenURL(), event.getAnio(), event.getDuracion(), event.getGenero(), event.getSipnosis(), event.getVideoURL()));
        });
    }

}
