package lotto.domain;


public class Money {
    private static int purchaseAmount = 0;
    private static final int MIN_AMOUNT = 1000;
    private static final String ERROR_AMOUNT_TOO_LOW = String.format("%d보다 큰 값을 입력해 주세요.", MIN_AMOUNT);
    private static final String ERROR_MULTIPLE_OF_THOUSAND = String.format("%d의 배수값만 입력해 주세요.",MIN_AMOUNT);
    public Money(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public double getEarningRate(long profit){
        return ((double) profit / purchaseAmount) * 100;
    }

    private static void validate(int money) {
        if (money < MIN_AMOUNT) {
            throw new IllegalArgumentException(ERROR_AMOUNT_TOO_LOW);
        } else if (money % MIN_AMOUNT != 0) {
            throw new IllegalArgumentException(ERROR_MULTIPLE_OF_THOUSAND);
        }
    }

}
