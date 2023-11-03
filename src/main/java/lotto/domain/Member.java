package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class Member {
    private final int purchasedMoney;
    private List<Lotto> purchasedLottos;

    public Member(final int purchasedMoney, final List<Lotto> purchasedLottos) {
        this.purchasedMoney = purchasedMoney;
        this.purchasedLottos = purchasedLottos;
    }

    public List<Lotto> getLottos() {
        return purchasedLottos;
    }
}
