package laura.whatsonopgave.controller;

import laura.whatsonopgave.model.Band;
import laura.whatsonopgave.model.Event;
import laura.whatsonopgave.model.User;
import laura.whatsonopgave.service.IBandService;
import laura.whatsonopgave.service.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class EventController {
    private IEventService eventService;
    private IBandService bandService;


    public EventController(IEventService eventService, IBandService bandService ) {
        this.eventService = eventService;
        this.bandService = bandService;
    }

    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent (@RequestBody Event event, @RequestParam Long bandID) {
        //Find band
        Optional<Band> theBand = bandService.findById(bandID); //Optional:
        if (theBand.isPresent()){
            event.setBand(theBand.get());
            eventService.save(event);
            return new ResponseEntity<>("Band id fundet - oprettet event", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Band ikke fundet med id: " + bandID + " Event ikke oprettet", HttpStatus.OK);
        }

    }

    @GetMapping("/allEvents")
    public ResponseEntity<Set<Event>> getAllEvents (){
        //Gem listen
        Set<Event> allEvents = eventService.findAll();
        return new ResponseEntity<>(allEvents, HttpStatus.OK);
    }
}
