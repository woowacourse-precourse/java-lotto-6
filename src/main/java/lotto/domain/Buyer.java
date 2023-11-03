package lotto.domain;

import java.util.List;

public class Buyer {

    public int purchaseAmount;
    public List<Lotto> lottos;

    public Buyer(int amount, List<Lotto> lottos) {
        this.purchaseAmount = amount;
        this.lottos = lottos;
    }

    public void getPurchaseAmount(int amount) {

    }
}
