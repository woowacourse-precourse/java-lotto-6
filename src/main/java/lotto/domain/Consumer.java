package lotto.domain;

import java.util.List;

public class Consumer {
    private final List<Lotto> purchasedLotto;

    public Consumer(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

}
