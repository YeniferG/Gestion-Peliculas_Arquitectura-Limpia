package co.com.sofka.estreno.infra.handle;

import co.com.sofka.estreno.domain.estreno.command.ConfigureEstrenoCommand;
import co.com.sofka.estreno.infra.generic.UseCaseHandle;
import co.com.sofka.estreno.usecases.ConfigureEstrenoUseCase;
import io.quarkus.vertx.ConsumeEvent;

public class ConfigureEstrenoHandle extends UseCaseHandle {

    private final ConfigureEstrenoUseCase useCase;

    public ConfigureEstrenoHandle(ConfigureEstrenoUseCase useCase){
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.estreno.create")
    void consumeBlocking(ConfigureEstrenoCommand command) {
        var events = useCase.apply(command);
        save(command.getEstrenoId(), events);
    }

}
