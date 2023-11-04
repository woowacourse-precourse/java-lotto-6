package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
