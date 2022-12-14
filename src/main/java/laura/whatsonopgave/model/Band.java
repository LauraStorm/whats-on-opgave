package laura.whatsonopgave.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany (mappedBy = "band")   //Event klassen har allerede mappet til denne band klasse.
                                     // Derfor behøver JPA ikke at mappe fra band til event
    private Set<Event> events = new HashSet<>();

    @ManyToMany(mappedBy = "bandsLiked") //mappedby kommer
    @JsonBackReference
    private Set<User> userLikes = new HashSet<>();


}
