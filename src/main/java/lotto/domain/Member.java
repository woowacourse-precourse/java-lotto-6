package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class Member {
    private final int purchasedPrice;
    private final int purchasedCount;
    private List<Lotto> purchasedLottos;

    public Member(final int purchasedPrice, final List<Lotto> purchasedLottos) {
        this.purchasedPrice = purchasedPrice;
        this.purchasedCount = purchasedPrice / 1000;
        this.purchasedLottos = purchasedLottos;
    }
    public List<Lotto> getLottos() {
        return purchasedLottos;
    }

    public int getPurchasedPrice() {
        return purchasedPrice;
    }

    public int getPurchasedCount() {
        return purchasedCount;
    }
}
