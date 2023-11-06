package lotto.repository;

import lotto.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    public UserRepository() {
        this.id = 0l;
    }

    private Map<Long, User> userDB = new HashMap<Long, User>();
    private Long id;
    public Long save(User saveUser) {
        saveUser.setId(id);
        userDB.put(id, saveUser);
        return id++;
    }

    public User findById(Long userId) {
        return userDB.get(userId);
    }
}
