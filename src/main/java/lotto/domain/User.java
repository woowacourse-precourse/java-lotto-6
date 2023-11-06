package lotto.domain;

import java.util.List;


public class User {
    private final int amount;
    private final List<Lotto> lottos;

    public User(int amount, List<Lotto> lottos) {
        this.amount = amount;
        this.lottos = lottos;
    }
    public List<Lotto> getLottos() {
        return lottos;
    }
    public int getAmount() {
        return amount;
    }

}
