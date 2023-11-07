package lotto.domain;

import java.util.List;

public class Cunsumer {
    private final List<Lotto> purchasedLotto;

    public Cunsumer(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

}
