package lotto.domain;

import lotto.Lotto;

import java.util.List;

import static lotto.constant.constant.LOTTO_PURCHASED_UNIT;

public class Member {

    private final int purchasedPrice;
    private final int purchasedCount;
    private List<Lotto> purchasedLottos;

    public Member(final int purchasedPrice, final List<Lotto> purchasedLottos) {
        this.purchasedPrice = purchasedPrice;
        this.purchasedCount = purchasedPrice / LOTTO_PURCHASED_UNIT;
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
