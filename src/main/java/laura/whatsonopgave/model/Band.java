package laura.whatsonopgave.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany (mappedBy = "band") //Event klassen har allerede mappet til
    //denne band klasse. Derfor behøver JPA ikke at mappe fra band til event
    private Set<Event> events = new HashSet<>();

}
