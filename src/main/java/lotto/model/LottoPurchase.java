package lotto.model;

import static lotto.util.Constant.LOTTO_PER_PRICE;

public class LottoPurchase {
    private int lottoPurchaseCount;

    private int getLottoPurchaseCount(int totalPrice) {
        return totalPrice / LOTTO_PER_PRICE;
    }

    private void setLottoPurchaseCount(String inputNumber) {
        int totalPrice = Integer.parseInt(inputNumber);
        this.lottoPurchaseCount = getLottoPurchaseCount(totalPrice);
    }
}