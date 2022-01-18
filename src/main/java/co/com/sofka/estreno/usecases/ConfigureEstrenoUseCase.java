package co.com.sofka.estreno.usecases;

import co.com.sofka.estreno.domain.estreno.Estreno;
import co.com.sofka.estreno.domain.estreno.command.ConfigureEstrenoCommand;
import co.com.sofka.estreno.domain.generic.DomainEvent;

import java.util.List;
import java.util.function.Function;

public class ConfigureEstrenoUseCase implements Function<ConfigureEstrenoCommand, List<DomainEvent>> {

    @Override
    public List<DomainEvent> apply(ConfigureEstrenoCommand command) {
        var estreno = new Estreno(command.getEstrenoId(), command.getNombre());
        return estreno.getUncommittedChanges();
    }

}
