package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class Member {
    private final int purchasedCount;
    private List<Lotto> purchasedLottos;

    public Member(final int purchasedCount, final List<Lotto> purchasedLottos) {
        this.purchasedCount = purchasedCount / 1000;
        this.purchasedLottos = purchasedLottos;
    }
    public List<Lotto> getLottos() {
        return purchasedLottos;
    }

    public int getPurchasedCount() {
        return purchasedCount;
    }
}
