package lotto.domain;

import lotto.view.Output;

public class Money {
    private static int purchaseAmount = 0;
    private static final int MIN_AMOUNT = 1000;

    public Money(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public double getEarningRate(long profit){
        return (profit-purchaseAmount)/purchaseAmount *100;
    }

    private static void validate(int money) {
        if (money < MIN_AMOUNT) {
            throw new IllegalArgumentException(MIN_AMOUNT + "보다 큰 값을 입력해 주세요.");
        } else if (money % MIN_AMOUNT != 0) {
            throw new IllegalArgumentException(MIN_AMOUNT + "의 배수값만 입력해 주세요.");
        }
    }

}
