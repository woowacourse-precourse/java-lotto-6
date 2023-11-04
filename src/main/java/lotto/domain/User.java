package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Money money;
    private List<Lotto> lottos;
    public User(Money money) {
        this.money = money;
        this.lottos = new ArrayList<>();
    }

    public boolean buy(Money lottoPrice, Lotto lotto) {
        if(money.hasNotMoney()) {
            return false;
        }

        money = money.minus(lottoPrice);
        lottos.add(lotto);

        return true;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

}
