package lotto.service;

import lotto.domain.User;
import lotto.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void saveUser(User user){
        userRepository.save(new User(user.getPurchaseAmount()));
    }
}
