package laura.whatsonopgave.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;
    private Timestamp timestamp;  //Format: "2022-09-22T07:08:52.713+00:00"

    @ManyToOne //Laver automatisk en Join kolonne
    @JsonBackReference //JSON den skal ikke blive ved med at = cikulær reference i @RestController
    private Band band; //bandId kolonne i event

    @OneToMany (mappedBy = "event")
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();


}
