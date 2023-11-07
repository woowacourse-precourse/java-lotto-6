package lotto.domain;

import java.util.List;

public class Ticket {
    private final List<Lotto> lottos;
    private final int purchaseAmount;

    public Ticket(List<Lotto> lottos) {
        this.lottos = lottos;
        this.purchaseAmount = lottos.size() * 1000;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
