package lotto.domain;

public class Player {

    private final PurchasePrice purchasePrice;

    private final Lottos lottos;

    private Player(PurchasePrice purchasePrice, Lottos lottos) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
    }

    public static Player of(PurchasePrice purchasePrice, Lottos lottos) {
        return new Player(purchasePrice, lottos);
    }

    public PurchasePrice getPurchasePrice() {
        return purchasePrice;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
