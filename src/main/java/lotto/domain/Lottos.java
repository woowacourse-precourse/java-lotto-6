package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int money) {
        this.lottos = buyLottos(money);
    }

    private List<Lotto> buyLottos(int money) {
    }
}
