package lotto.domain;

import java.util.List;

public class User {
    private final List<Lotto> lottos;

    private User(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static User provideLottos(final List<Lotto> lottos) {
        return new User(lottos);
    }
}
