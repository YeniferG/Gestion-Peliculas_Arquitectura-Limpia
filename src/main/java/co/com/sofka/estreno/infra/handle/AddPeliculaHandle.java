package co.com.sofka.estreno.infra.handle;

import co.com.sofka.estreno.domain.estreno.command.AddPeliculaCommand;
import co.com.sofka.estreno.infra.generic.UseCaseHandle;
import co.com.sofka.estreno.usecases.AddPeliculaUseCase;
import io.quarkus.vertx.ConsumeEvent;

public class AddPeliculaHandle extends UseCaseHandle {

    private final AddPeliculaUseCase useCase;

    public AddPeliculaHandle(AddPeliculaUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.estreno.addpelicula")
    void consumeBlocking(AddPeliculaCommand command) {
        var events = useCase.apply(command);
        save(command.getPeliculaId(), events);
    }

}
