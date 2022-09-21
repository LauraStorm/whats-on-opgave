package laura.whatsonopgave.controller;

import laura.whatsonopgave.model.Event;
import laura.whatsonopgave.model.Review;
import laura.whatsonopgave.model.User;
import laura.whatsonopgave.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
public class ReviewController {
    private IReviewService reviewService;
    private IUserService userService;
    private IEventService eventService;

    public ReviewController(IReviewService reviewService, IUserService userService, IEventService eventService) {
        this.reviewService = reviewService;
        this.userService = userService;
        this.eventService = eventService;
    }

    @GetMapping("/allReviews")
    public ResponseEntity<Set<Event>> getAllReviews (){
        Set<Review> allReviews = reviewService.findAll();
        return new ResponseEntity (allReviews, HttpStatus.OK);
    }

    @PostMapping("/createReview")
    public ResponseEntity<String> saveReview (@RequestBody Review review, @RequestParam Long eventID, @RequestParam Long userID) {
        Optional<Event> chosenEvent = eventService.findById(eventID);
        Optional<User> chosenUser = userService.findById(userID);

        if (chosenEvent.isPresent() && chosenUser.isPresent()) {
            review.setEvent(chosenEvent.get());
            review.setUser(chosenUser.get());
            reviewService.save(review);
            return new ResponseEntity<>("User id + Event id er Fundet! Review er gemt/oprettet!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User id eller/og Event id er ikke fundet", HttpStatus.OK);
        }
    }






}
