package laura.whatsonopgave.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data  //...hashCode
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;

    @ManyToOne //Laver automatisk en Join kolonne
    @JsonBackReference //JSON den skal ikke blive ved med at = cikulær reference i @RestController
    @EqualsAndHashCode.Exclude //Fordi vi bruger @Data = hashcode() problem
    private Band band; //bandId kolonne i event

    @OneToMany (mappedBy = "event")
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();


}
