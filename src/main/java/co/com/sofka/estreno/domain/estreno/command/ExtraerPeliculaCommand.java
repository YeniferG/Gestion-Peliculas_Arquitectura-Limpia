package co.com.sofka.estreno.domain.estreno.command;

import co.com.sofka.estreno.domain.generic.Command;

public class ExtraerPeliculaCommand extends Command {

    private String estrenoId;

    public ExtraerPeliculaCommand() {
    }

    public String getEstrenoId() {
        return estrenoId;
    }

    public void setEstrenoId(String estrenoId) {
        this.estrenoId = estrenoId;
    }
}
