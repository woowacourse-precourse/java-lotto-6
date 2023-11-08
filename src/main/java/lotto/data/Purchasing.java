package lotto.data;

import java.util.List;

public class Purchasing {
    private int purchasedPrice;
    private List<Lotto> lottos;

    public Purchasing(int purchasedPrice, List<Lotto> lottos) {
        this.purchasedPrice = purchasedPrice;
        this.lottos = lottos;
    }

    public int getPurchasedPrice() {
        return purchasedPrice;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
