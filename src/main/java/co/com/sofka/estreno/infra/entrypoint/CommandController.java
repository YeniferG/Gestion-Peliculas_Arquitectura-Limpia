package co.com.sofka.estreno.infra.entrypoint;

import co.com.sofka.estreno.domain.estreno.command.AddPeliculaCommand;
import co.com.sofka.estreno.domain.estreno.command.ConfigureEstrenoCommand;
import co.com.sofka.estreno.domain.estreno.command.ExtractPeliculaCommand;
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
    @Path("/create")
    public Response executor(ConfigureEstrenoCommand command){
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMovie")
    public Response executor(AddPeliculaCommand command){
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/extractMovie")
    public Response executor(ExtractPeliculaCommand command){
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

}
