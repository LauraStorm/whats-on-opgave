package laura.whatsonopgave.controller;

import laura.whatsonopgave.model.User;
import laura.whatsonopgave.service.IUserService;
import laura.whatsonopgave.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
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

    @GetMapping("/allUsers")
    public ResponseEntity<Set<User>> getAllUsers (){
        //Gem listen
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
}
