package laura.whatsonopgave.service;

import laura.whatsonopgave.model.Venue;
import laura.whatsonopgave.repositories.VenueRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class VenueService implements IVenueService{
    private VenueRepo venueRepo;

    public VenueService(VenueRepo venueRepo) {
        this.venueRepo = venueRepo;
    }

    @Override
    public Set<Venue> findAll() {
        Set<Venue> allVenues = new HashSet<>();
        venueRepo.findAll().forEach(allVenues::add);
        System.out.println("Venue list size: " + allVenues.size());
        return allVenues;
    }

    @Override
    public Venue save(Venue object) {
        return venueRepo.save(object);
    }

    @Override
    public void delete(Venue object) {
        venueRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        venueRepo.deleteById(aLong);
    }

    @Override
    public Optional<Venue> findById(Long aLong) {
        return venueRepo.findById(aLong);
    }
}
