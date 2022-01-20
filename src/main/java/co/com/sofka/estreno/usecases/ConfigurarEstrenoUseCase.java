package co.com.sofka.estreno.usecases;

import co.com.sofka.estreno.domain.estreno.Estreno;
import co.com.sofka.estreno.domain.estreno.command.ConfigurarEstrenoCommand;
import co.com.sofka.estreno.domain.generic.DomainEvent;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class ConfigurarEstrenoUseCase implements Function<ConfigurarEstrenoCommand, List<DomainEvent>> {

    @Override
    public List<DomainEvent> apply(ConfigurarEstrenoCommand command) {
        var estreno = new Estreno(command.getEstrenoId(), command.getNombre());
        return estreno.getUncommittedChanges();
    }

}
