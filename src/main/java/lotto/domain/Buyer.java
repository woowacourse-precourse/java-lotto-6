package lotto.domain;

import java.util.List;

public class Buyer {

    private final int purchaseAmount;
    private final List<Lotto> lottos;

    public Buyer(int purchaseAmount, List<Lotto> lottos) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
    }
}
