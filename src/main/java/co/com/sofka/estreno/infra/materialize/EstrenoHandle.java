package co.com.sofka.estreno.infra.materialize;


import co.com.sofka.estreno.domain.estreno.event.EstrenoCreated;
import co.com.sofka.estreno.domain.estreno.event.PeliculaAdded;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import io.quarkus.vertx.ConsumeEvent;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class EstrenoHandle {

    private final MongoClient mongoClient;

    public EstrenoHandle(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @ConsumeEvent(value = "sofka.estreno.estrenocreated", blocking = true)
    void consumeEstrenoCreated(EstrenoCreated event) {
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("name", event.getNombre());

        mongoClient.getDatabase("queries")
                .getCollection("estreno")
                .insertOne(new Document(document));
    }

    @ConsumeEvent(value = "sofka.estreno.peliculaadded", blocking = true)
    void consumePeliculaAdded(PeliculaAdded event) {
        BasicDBObject document = new BasicDBObject();
        document.put("pelicula."+event.getTitulo()+".titulo", event.getTitulo());
        document.put("pelicula."+event.getTitulo()+".anio", event.getAnio());
        document.put("pelicula."+event.getTitulo()+".duracion", event.getDuracion());
        document.put("pelicula."+event.getTitulo()+".genero", event.getGenero());
        document.put("pelicula."+event.getTitulo()+".sipnosis", event.getSipnosis());
        document.put("pelicula."+event.getTitulo()+".videoURL", event.getVideoURL());

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);

        mongoClient.getDatabase("queries")
                .getCollection("estreno")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }
}
