package laura.whatsonopgave.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private int rate;

    @ManyToOne                      //Laver automatisk en Join kolonne
    //@JsonBackReference              //JSON den skal ikke blive ved med at = cikulær reference i @RestController
    @EqualsAndHashCode.Exclude      //Fordi vi bruger @Data = hashcode() problem
    private Event event;

    @ManyToOne
    //@JsonBackReference
    @EqualsAndHashCode.Exclude
    private User user;

}
