package co.com.sofka.estreno.infra.handle;

import co.com.sofka.estreno.domain.estreno.command.ConfigurarEstrenoCommand;
import co.com.sofka.estreno.infra.generic.UseCaseHandle;
import co.com.sofka.estreno.usecases.ConfigurarEstrenoUseCase;
import io.quarkus.vertx.ConsumeEvent;

public class ConfigurarEstrenoHandle extends UseCaseHandle {

    private final ConfigurarEstrenoUseCase useCase;

    public ConfigurarEstrenoHandle(ConfigurarEstrenoUseCase useCase){
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.estreno.crear")
    void consumeBlocking(ConfigurarEstrenoCommand command) {
        var events = useCase.apply(command);
        save(command.getEstrenoId(), events);
    }

}
