package lotto.domain;

import java.util.List;

public class PurchasedLotto {
    private final List<Lotto> lotto;

    public PurchasedLotto(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
