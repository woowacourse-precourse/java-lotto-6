package lotto.domain;

import java.util.List;

public class PlayerLotto {
    private final List<Lotto> lottos;

    public PlayerLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
