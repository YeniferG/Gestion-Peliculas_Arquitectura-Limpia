package co.com.sofka.estreno.infra.handle;

import co.com.sofka.estreno.domain.estreno.command.AgregarPeliculaCommand;
import co.com.sofka.estreno.infra.generic.UseCaseHandle;
import co.com.sofka.estreno.usecases.AgregarPeliculaUseCase;
import io.quarkus.vertx.ConsumeEvent;

public class AgregarPeliculaHandle extends UseCaseHandle {

    private final AgregarPeliculaUseCase useCase;

    public AgregarPeliculaHandle(AgregarPeliculaUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.estreno.agregarpelicula")
    void consumeBlocking(AgregarPeliculaCommand command) {
        var events = useCase.apply(command);
        save(command.getPeliculaId(), events);
    }

}
