package co.com.sofka.estreno.domain.estreno.event;

import co.com.sofka.estreno.domain.generic.DomainEvent;

public class EstrenoCreado extends DomainEvent {

    private final String estrenoId;
    private final String nombre;

    public EstrenoCreado(String id, String nombre) {
        super("sofka.estreno.estrenocreado");
        this.estrenoId = id;
        this.nombre = nombre;
    }

    public String getEstrenoId() {
        return estrenoId;
    }

    public String getNombre() {
        return nombre;
    }
}
