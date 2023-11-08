package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public long getNumberOfLottos() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}