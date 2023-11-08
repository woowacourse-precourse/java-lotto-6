package lotto.service;

import lotto.domain.PurchasePrice;
import lotto.domain.WinningCriteria;
import lotto.domain.WinningDetails;
import lotto.domain.WinningPrice;

public class PriceService {

    private static final int LOTTO_UNIT = 1000;
    private static final int PERCENTAGE = 100;

    private PurchasePrice purchasePrice;
    private WinningPrice winningPrice;

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);
    }

    public int getLottoPurchaseQuantity() {
        return purchasePrice.getPurchasePrice() / LOTTO_UNIT;
    }

    public void calculateWinningPrice(WinningDetails winningDetails) {
        long winningPrice = 0;

        for (WinningCriteria winningCriteria : WinningCriteria.values()) {
            winningPrice += winningDetails.getWinningCount(winningCriteria.getRank()) * winningCriteria.getPrice();
        }

        this.winningPrice = new WinningPrice(winningPrice);
    }

    public float getEarningRate() {
        return winningPrice.getWinningPrice() / purchasePrice.getPurchasePrice() * PERCENTAGE;
    }
}
