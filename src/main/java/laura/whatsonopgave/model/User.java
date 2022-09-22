package laura.whatsonopgave.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
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
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany (mappedBy = "user")
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();

    //ManytoMany
    @ManyToMany
    @JoinTable //opretter ny tabel.
    (
            //name = hvad skal den nye tabel hedde --> navngiv den
            name = "venue_Like",
            joinColumns = @JoinColumn(name = "user_id"),
            //inverseJoinColumn =
            inverseJoinColumns = @JoinColumn(name = "venue_id")
    )
    @JsonBackReference
    private Set<Venue> venuesLiked = new HashSet<>();

    //mange Users kan like mange Bands
    @ManyToMany
    @JoinTable(
            name = "band_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "band_id")
    )
    @JsonBackReference
    private Set<Band> bandsLiked = new HashSet<>();




}
