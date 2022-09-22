package laura.whatsonopgave.service;

import laura.whatsonopgave.model.User;
import laura.whatsonopgave.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service  // gør at spring ''ser'' denne klasse
public class UserService implements IUserService{
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Set<User> findAll() {
        Set<User> allUser = new HashSet<>();
        userRepo.findAll().forEach(allUser::add);
        System.out.println("users list size: " + allUser.size());
        return allUser;
    }

    @Override
    public User save(User object) {
        userRepo.save(object);
        return object;
    }

    @Override
    public void delete(User object) {
        userRepo.delete(object);
        System.out.println("You deleted: " + object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
        System.out.println("You deleted the user with id : " + aLong );
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepo.findById(aLong);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepo.findUserByName(name);
    }
}
