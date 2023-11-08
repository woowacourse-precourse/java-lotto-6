package lotto.repository;

import lotto.domain.Game;
import lotto.domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Long id = 0L;
    private final Map<Long, User> users = new HashMap<>();

    public Long save(User user) {
        users.put(id, user);
        id += 1;
        return id;
    }

}
