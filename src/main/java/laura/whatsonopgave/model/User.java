package laura.whatsonopgave.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data //Laver getters, setters, toString(), hashcode()
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



}
