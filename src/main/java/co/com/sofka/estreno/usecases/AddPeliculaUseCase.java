package co.com.sofka.estreno.usecases;

import co.com.sofka.estreno.domain.estreno.Estreno;
import co.com.sofka.estreno.domain.estreno.command.AddPeliculaCommand;
import co.com.sofka.estreno.domain.generic.DomainEvent;
import co.com.sofka.estreno.domain.generic.EventStoreRepository;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class AddPeliculaUseCase implements Function<AddPeliculaCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AddPeliculaUseCase(EventStoreRepository repository){
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AddPeliculaCommand command) {
        var events = repository.getEventsBy("estreno", command.getEstrenoId());
        var estreno = Estreno.from(command.getEstrenoId(), events);
        estreno.addPelicula(command.getPeliculaId(), command.getTitulo(), command.getAnio(), command.getDuracion(), command.getGenero(), command.getSipnosis(), command.getVideoURL());
        return estreno.getUncommittedChanges();
    }

}
