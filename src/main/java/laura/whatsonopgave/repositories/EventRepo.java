package laura.whatsonopgave.repositories;

import laura.whatsonopgave.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
}
