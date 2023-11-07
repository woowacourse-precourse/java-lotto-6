package lotto.model.domain;

import lotto.model.domain.vo.Lottos;
import lotto.model.domain.vo.Money;

public class Player {

    private Money money;
    private Lottos lottos;

    private Player(Money money, Lottos lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public static Player from(Money money, Lottos lottos) {
        return new Player(money, lottos);
    }

    public Money getMoney() {
        return money;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
