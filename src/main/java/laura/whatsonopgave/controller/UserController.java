package laura.whatsonopgave.controller;

import laura.whatsonopgave.model.Band;
import laura.whatsonopgave.model.User;
import laura.whatsonopgave.model.Venue;
import laura.whatsonopgave.service.IBandService;
import laura.whatsonopgave.service.IUserService;
import laura.whatsonopgave.service.IVenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
public class UserController {
    private IUserService userService;
    private IVenueService venueService;
    private IBandService bandService;

    public UserController(IUserService userService, IVenueService venueService, IBandService bandService) {
        this.userService = userService;
        this.venueService = venueService;
        this.bandService = bandService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser (@RequestBody User user){
        String userMessage ="";
        if (userService.save(user) != null){
            userMessage = "Oprettet user: " + user.getName();
        } else {
            userMessage = "Fejl i user oprettelse af: " + user.getName();
        }

        return new ResponseEntity<>(userMessage, HttpStatus.OK);
    }

    @PostMapping("/createLike")
    public ResponseEntity<String> createLike (@RequestParam Long userID, @RequestParam Long venueID){
        //Optional kan også returnere null
        Optional<User> user = userService.findById(userID);
        Optional<Venue> venue = venueService.findById(venueID);

        if (user.isPresent() && venue.isPresent()){
            user.get().getVenuesLiked().add(venue.get());
            userService.save(user.get());
            return new ResponseEntity<>("Ok at gemme user: " + userID + " med like venue " + venueID, HttpStatus.OK);
        }

        return new ResponseEntity<>("Fejl ved oprettelse af venue like!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/createBandLike")
    public ResponseEntity<String> createBandLike (@RequestParam Long userID, @RequestParam Long bandID){
        Optional<User> user_ = userService.findById(userID);
        Optional<Band> band_ = bandService.findById(bandID);

        if (user_.isPresent() && band_.isPresent()){
            user_.get().getBandsLiked().add(band_.get());
            userService.save(user_.get());
            return new ResponseEntity<>("User med id " + userID + " er gemt med liked band id " + bandID, HttpStatus.OK);
        }
        return new ResponseEntity<>("Fejl ved oprettelse af bandsliked..", HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/allUsers")
    public ResponseEntity<Set<User>> getAllUsers (){
        Set<User> allUsers = userService.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Long> deleteUserById(@RequestParam ("id") Long id){
        userService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser (@RequestParam ("id") long id, @RequestBody User user){
        //Find user via id
        User userToUpdate = userService.findById(id).get();
        //Ændre user's værdier
        userToUpdate.setName(user.getName());
        //Gem de nye værdier
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getUserByName")
    public ResponseEntity<List<User>> getUserByName (String name){
        return new ResponseEntity<> (userService.findUserByName(name), HttpStatus.OK);
    }
}
