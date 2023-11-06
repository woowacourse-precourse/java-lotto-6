package lotto.domain;

import java.util.List;

public class User {
    private final List<Lotto> lottos;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
