package laura.whatsonopgave.controller;

import laura.whatsonopgave.model.User;
import laura.whatsonopgave.model.Venue;
import laura.whatsonopgave.service.IVenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class VenueController {
    private IVenueService venueService;

    public VenueController(IVenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping("/createVenue")
    public ResponseEntity<String> createVenue (@RequestBody Venue venue){
        String venueMessage ="";
        if (venueService.save(venue) != null){
            venueMessage ="Oprettet venue: " + venue.getName();
        } else {
            venueMessage = "Fejl i venue oprettelse: " + venue.getName();
        }
        return new ResponseEntity<> (venueMessage,HttpStatus.OK);
    }

    @GetMapping("/allVenues")
    public ResponseEntity<Set<Venue>> getVenues (){
        //Gem listen
        Set<Venue> allVenues = venueService.findAll();
        return new ResponseEntity<>(allVenues, HttpStatus.OK);
    }
}
