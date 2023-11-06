package lotto.domain;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> bundle;

    public LottoBundle(List<Lotto> lottos) {
        this.bundle = lottos;
    }

    public List<Lotto> getBundle() {
        return bundle;
    }
}
