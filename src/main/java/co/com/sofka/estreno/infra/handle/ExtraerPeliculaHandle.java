package co.com.sofka.estreno.infra.handle;

import co.com.sofka.estreno.domain.estreno.command.ExtraerPeliculaCommand;
import co.com.sofka.estreno.infra.generic.UseCaseHandle;
import co.com.sofka.estreno.usecases.ExtraerPeliculasUseCase;
import io.quarkus.vertx.ConsumeEvent;

public class ExtraerPeliculaHandle extends UseCaseHandle {

    private final ExtraerPeliculasUseCase useCase;

    public ExtraerPeliculaHandle(ExtraerPeliculasUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.estreno.extraerpelicula")
    void consumeBlocking(ExtraerPeliculaCommand command) {
        var events = useCase.apply(command);
        save(command.getEstrenoId(), events);
    }

}
