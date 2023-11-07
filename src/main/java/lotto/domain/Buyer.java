package lotto.domain;

import java.util.List;

public class Buyer {

    private final List<Lotto> lottos;

    public Buyer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
