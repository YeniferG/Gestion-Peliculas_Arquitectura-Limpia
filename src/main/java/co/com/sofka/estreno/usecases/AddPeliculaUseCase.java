package co.com.sofka.estreno.usecases;

import co.com.sofka.estreno.domain.estreno.Estreno;
import co.com.sofka.estreno.domain.estreno.command.AddPeliculaCommand;
import co.com.sofka.estreno.domain.generic.DomainEvent;
import co.com.sofka.estreno.domain.generic.EventStoreRepository;

import java.util.List;
import java.util.function.Function;

public class AddPeliculaUseCase implements Function<AddPeliculaCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AddPeliculaUseCase(EventStoreRepository repository){
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AddPeliculaCommand command) {
        var events = repository.getEventsBy("estreno", command.getPeliculaId());
        var estreno = Estreno.from(command.getEstrenoId(), events);
        estreno.addPelicula(command.getPeliculaId(), command.getTitulo(), command.getAnio(), command.getDuracion(), command.getSipnosis(), command.getGenero(), command.getVideoURL());
        return estreno.getUncommittedChanges();
    }

}
