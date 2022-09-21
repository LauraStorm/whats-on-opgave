package laura.whatsonopgave.service;

import laura.whatsonopgave.model.Review;
import laura.whatsonopgave.repositories.ReviewRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ReviewService implements IReviewService {
    private ReviewRepo reviewRepo;

    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public Set<Review> findAll() {
        Set<Review> reviews = new HashSet<>();
        reviewRepo.findAll().forEach(reviews::add);
        System.out.println("Review list size: " + reviews.size());
        return reviews;
    }

    @Override
    public Review save(Review object) {
        reviewRepo.save(object);
        return object;
    }

    @Override
    public void delete(Review object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return Optional.empty();
    }
}
