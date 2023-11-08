package lotto.domain;

import java.util.List;

public class LottoPlayer {

    private int purchasePrice;
    private List<Lotto> lottos;

    public LottoPlayer(int purchasePrice, List<Lotto> lottos) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
    
}
