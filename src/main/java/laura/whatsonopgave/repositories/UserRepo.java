package laura.whatsonopgave.repositories;

import laura.whatsonopgave.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    //Vi extender til CrudRepository, som allerede har metoder i sin class
    //Man kan bruge JpaRepository i stedet
}
