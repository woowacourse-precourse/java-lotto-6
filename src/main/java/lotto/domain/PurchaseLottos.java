package lotto.domain;

public class PurchaseLottos {
    private PurchasePrice purchasePrice;
    private Lottos lottos;

    public PurchaseLottos(PurchasePrice purchasePrice) {
        this.purchasePrice = purchasePrice;
        int count = purchasePrice.getCount();
        this.lottos = Lottos.from(count);
    }
}
