package lotto.model;

import java.util.List;

public class Buyer {
    private final Money money;
    private final List<Lotto> lottos;

    public Buyer(String inputMoney) {
        this.money = new Money(inputMoney);
        lottos = LottoStore.buyLotto(money);
    }
}
