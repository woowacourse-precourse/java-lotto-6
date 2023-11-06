package lotto.model;

import static lotto.Utils.convertStringToInt;

public class Purchase {
    private static final int LOTTOPRICE = 1000;
    private int purchasePrice;
    private int lottoCount;

    public Purchase(String purchasePriceInput) {
        this.purchasePrice = convertStringToInt(purchasePriceInput);
        calculateLottoCount();
    }

    private void calculateLottoCount() {
        this.lottoCount = purchasePrice / LOTTOPRICE;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
