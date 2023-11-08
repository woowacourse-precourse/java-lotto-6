package lotto.domain;

public class Purchase {
    private final int purchasePrice;
    private final int finalRound;

    public Purchase(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.finalRound = purchasePrice / 1000;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getFinalRound() {
        return finalRound;
    }
}
