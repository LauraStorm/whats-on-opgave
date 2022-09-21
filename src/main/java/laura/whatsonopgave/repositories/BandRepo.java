package laura.whatsonopgave.repositories;

import laura.whatsonopgave.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepo extends JpaRepository<Band, Long> {
    //Henter metoder fra klassen JPA REPO
}
