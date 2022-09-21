package laura.whatsonopgave.service;

import laura.whatsonopgave.model.Event;
import laura.whatsonopgave.repositories.EventRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EventService implements IEventService {
    private EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public Set<Event> findAll() {
        Set<Event> allEvents = new HashSet<>();
        eventRepo.findAll().forEach(allEvents::add);
        System.out.println("User list size: "+allEvents.size());
        return allEvents;
    }

    @Override
    public Event save(Event object) {
        eventRepo.save(object);
        return object;
    }

    @Override
    public void delete(Event object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Event> findById(Long aLong) {
        return eventRepo.findById(aLong);
    }
}
