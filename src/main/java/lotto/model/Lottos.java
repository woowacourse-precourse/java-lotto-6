package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos assemble(List<Lotto> lottos) {
        return new Lottos(lottos);
    }
}
