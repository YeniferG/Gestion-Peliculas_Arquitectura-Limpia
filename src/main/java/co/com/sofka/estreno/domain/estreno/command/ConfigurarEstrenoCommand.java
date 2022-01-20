package co.com.sofka.estreno.domain.estreno.command;

import co.com.sofka.estreno.domain.generic.Command;

public class ConfigurarEstrenoCommand extends Command {

    private String estrenoId;
    private String nombre;

    public String getEstrenoId() {
        return estrenoId;
    }

    public void setEstrenoId(String estrenoId) {
        this.estrenoId = estrenoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
