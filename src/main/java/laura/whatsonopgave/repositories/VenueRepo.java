package laura.whatsonopgave.repositories;

import laura.whatsonopgave.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepo extends JpaRepository<Venue, Long> {
}
