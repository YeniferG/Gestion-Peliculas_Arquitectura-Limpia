package co.com.sofka.estreno.domain.estreno.command;

import co.com.sofka.estreno.domain.generic.Command;

public class ExtractPeliculaCommand extends Command {

    private String estrenoId;

    public ExtractPeliculaCommand() {
    }

    public String getEstrenoId() {
        return estrenoId;
    }

    public void setEstrenoId(String estrenoId) {
        this.estrenoId = estrenoId;
    }
}
