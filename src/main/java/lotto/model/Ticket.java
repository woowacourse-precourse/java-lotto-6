package lotto.model;

import java.util.List;

public class Ticket {
    private final List<Lotto> lottos;
    private final int purchaseNum;

    public Ticket(List<Lotto> lottos, int purchaseNum) {
        this.lottos = lottos;
        this.purchaseNum = purchaseNum;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseNum() {
        return purchaseNum;
    }

}
