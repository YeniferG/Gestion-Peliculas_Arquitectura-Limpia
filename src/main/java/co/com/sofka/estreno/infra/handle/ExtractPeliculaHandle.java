package co.com.sofka.estreno.infra.handle;

import co.com.sofka.estreno.domain.estreno.command.ExtractPeliculaCommand;
import co.com.sofka.estreno.infra.generic.UseCaseHandle;
import co.com.sofka.estreno.usecases.ExtractPeliculasUseCase;
import io.quarkus.vertx.ConsumeEvent;

public class ExtractPeliculaHandle extends UseCaseHandle {

    private final ExtractPeliculasUseCase useCase;

    public ExtractPeliculaHandle(ExtractPeliculasUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.estreno.extractpelicula")
    void consumeBlocking(ExtractPeliculaCommand command) {
        var events = useCase.apply(command);
        save(command.getEstrenoId(), events);
    }

}
