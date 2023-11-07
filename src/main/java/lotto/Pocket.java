package lotto;

import java.util.List;

public class Pocket {
    private final List<Lotto> lottos;

    public Pocket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
