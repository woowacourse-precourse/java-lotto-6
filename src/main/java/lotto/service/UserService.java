package lotto.service;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.User;

public class UserService {
    private final Map<String, User> userRepository ;

    public UserService() {
        this.userRepository = new HashMap<>();
    }

    public User getUser(String name) {
        return userRepository.get(name);
    }

    public void register(String name){
        userRepository.put(name, new User());

    }
}
