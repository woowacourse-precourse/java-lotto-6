package lotto.domain;

import java.util.List;

public class Consumer {
    private List<Lotto> purchasedLotto;

    public Consumer(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }
}
