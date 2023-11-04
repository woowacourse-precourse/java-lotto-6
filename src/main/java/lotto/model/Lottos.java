package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLotto() {
        return lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
