package lotto.domain;

import java.util.List;

public class Lottos {
    private static final int TEN_THOUSAND = 1000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return lottos.size() * TEN_THOUSAND;
    }

    public int getAmount() {
        return lottos.size();
    }
}
