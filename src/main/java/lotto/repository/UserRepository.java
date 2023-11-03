package lotto.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.User;

public class UserRepository {
    private static final int ID = 1;
    private static final Map<Integer, User> userDB = new ConcurrentHashMap<>();

    public User find() {
        return userDB.get(ID);
    }

    public void save(User user) {
        userDB.put(ID, user);
    }
}
