package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;
    private final int number;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        this.number = lottos.size();
    }
}
