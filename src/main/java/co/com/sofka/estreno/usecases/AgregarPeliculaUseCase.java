package co.com.sofka.estreno.usecases;

import co.com.sofka.estreno.domain.estreno.Estreno;
import co.com.sofka.estreno.domain.estreno.command.AgregarPeliculaCommand;
import co.com.sofka.estreno.domain.generic.DomainEvent;
import co.com.sofka.estreno.domain.generic.EventStoreRepository;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class AgregarPeliculaUseCase implements Function<AgregarPeliculaCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AgregarPeliculaUseCase(EventStoreRepository repository){
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AgregarPeliculaCommand command) {
        var events = repository.getEventsBy("estreno", command.getEstrenoId());
        var estreno = Estreno.from(command.getEstrenoId(), events);
        estreno.agregarPelicula(command.getPeliculaId(), command.getTitulo(), command.getImagenURL(), command.getAnio(), command.getDuracion(), command.getGenero(), command.getSipnosis(), command.getVideoURL());
        return estreno.getUncommittedChanges();
    }

}
