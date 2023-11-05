package lotto.domain;

import java.util.List;

public class LottoStore {
    private final List<Lotto> lottos;

    public LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
