package co.com.sofka.estreno.infra.generic;

import co.com.sofka.estreno.domain.generic.DomainEvent;
import co.com.sofka.estreno.domain.generic.EventStoreRepository;
import co.com.sofka.estreno.domain.generic.StoredEvent;
import co.com.sofka.estreno.infra.message.BusService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public abstract class UseCaseHandle {

    @Inject
    private EventStoreRepository repository;

    @Inject
    private BusService busService;;

    public void save(String catalogoId, List<DomainEvent> events) {
        events.stream().map(event -> {
            String eventBody = EventSerializer.instance().serialize(event);
            return new StoredEvent(event.getClass().getTypeName(), new Date(), eventBody);
        }).forEach(storedEvent -> repository.saveEvent("estreno", catalogoId, storedEvent));

        events.forEach(busService::send);
    }

}
