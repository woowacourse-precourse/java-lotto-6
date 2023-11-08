package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Integer> lottos;

    public Lottos(List<Integer> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> getLottos() {
        return lottos;
    }
}
