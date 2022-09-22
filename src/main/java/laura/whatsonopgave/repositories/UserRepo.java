package laura.whatsonopgave.repositories;

import laura.whatsonopgave.model.Band;
import laura.whatsonopgave.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    //Vi extender til CrudRepository, som allerede har metoder i sin class
    //Man kan bruge JpaRepository i stedet

    List<User> findUserByName(String name);

}
