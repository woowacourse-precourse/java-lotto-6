package lotto.domain.lotto;

import static lotto.message.ErrorMessage.AMOUNT_LESS_THAN_ZERO;

public class Cash {
    private final long cash;

    public Cash(long cash) {
        validatePositiveNumber(cash);
        this.cash = cash;
    }

    public void validatePositiveNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException(AMOUNT_LESS_THAN_ZERO.getMessage());
        }
    }

    public boolean isPurchaseLottoPossible(int price) {
        return cash % price != 0;
    }

    public long countPurchasableItems(int price) {
        if (isPurchaseLottoPossible(price)){
            //에러 메시지 추가하기
            throw new IllegalArgumentException();
        }
        return cash / price;
    }

    public long getCash() {
        return cash;
    }
}
