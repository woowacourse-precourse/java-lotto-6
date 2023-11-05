package lotto.model;

import java.util.List;

public class Purchase {
    private Lottos lottos;
    private Money money;

    private Purchase(Lottos lottos, Money money) {
        this.lottos = lottos;
        this.money = money;
        lottos.addLotto(money.availableLottoCount());
    }

    public static Purchase purchase(Lottos lottos, Integer money) {
        return new Purchase(lottos, new Money(money));
    }

    public Integer getMoney() {
        return money.getMoney();
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public Integer getAvailableLotto() {
        return this.money.availableLottoCount();
    }
}
