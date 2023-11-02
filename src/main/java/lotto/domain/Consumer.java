package lotto.domain;

import lotto.view.OutputView;

import java.util.List;

public class Consumer {
    private List<Lotto> purchasedLotto;

    public Consumer(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
