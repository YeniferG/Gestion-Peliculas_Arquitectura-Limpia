package co.com.sofka.estreno.infra.entrypoint;

import co.com.sofka.estreno.domain.estreno.command.AgregarPeliculaCommand;
import co.com.sofka.estreno.domain.estreno.command.ConfigurarEstrenoCommand;
import co.com.sofka.estreno.domain.estreno.command.ExtraerPeliculaCommand;
import io.vertx.core.eventbus.EventBus;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/estreno")
public class CommandController {

    private final EventBus bus;

    public CommandController(EventBus bus){
        this.bus = bus;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/crear")
    public Response executor(ConfigurarEstrenoCommand command){
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/agregarPelicula")
    public Response executor(AgregarPeliculaCommand command){
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/extraerPelicula")
    public Response executor(ExtraerPeliculaCommand command){
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

}
