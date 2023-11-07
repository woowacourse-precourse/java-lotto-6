package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {
    private final List<Lotto> lottos;
    private final Money paidMoney;

    public LottoBuyer(List<Lotto> lottos, Money paidMoney) {
        this.lottos = lottos;
        this.paidMoney = paidMoney;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public Money getPaidMoney() {
        return paidMoney;
    }
}
