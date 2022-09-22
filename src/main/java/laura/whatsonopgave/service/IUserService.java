package laura.whatsonopgave.service;

import laura.whatsonopgave.model.User;

import java.util.List;

public interface IUserService extends ICrudService <User, Long>{
    List<User> findUserByName(String name);
}
