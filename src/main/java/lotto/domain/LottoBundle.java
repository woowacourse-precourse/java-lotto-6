package lotto.domain;

import java.util.List;

public class LottoBundle {

    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }
}
