package laura.whatsonopgave.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
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
    private Event event;

    @ManyToOne
    //@JsonBackReference
    private User user;

}
