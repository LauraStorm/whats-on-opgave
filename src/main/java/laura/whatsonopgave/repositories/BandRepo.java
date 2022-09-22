package laura.whatsonopgave.repositories;

import laura.whatsonopgave.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BandRepo extends JpaRepository<Band, Long> {
    //Henter metoder fra klassen JPA REPO

    List<Band> findBandByName(String name); //Du kan flere ting. eks. sortere ved at skrive 'findBandByNameOrderById'

}
