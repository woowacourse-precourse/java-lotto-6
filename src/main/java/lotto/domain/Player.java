package lotto.domain;

import java.util.List;

public class Player {
    private final List<Lotto> lottos;

    public Player(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
