package lotto.domain;

public class BuyAmount {

    private static final String DIVISION_ERROR_MESSAGE = "1000원으로 나눌 수 있는 금액만 입력 가능합니다.";
    private final int buyAmount;

    public BuyAmount(int buyAmount) {
        validateAbleToDivide(buyAmount);
        this.buyAmount = buyAmount;
    }

    public void validateAbleToDivide(int buyAmount) {
        if (buyAmount % 1000 != 0) {
            throw new IllegalArgumentException(DIVISION_ERROR_MESSAGE);
        }
    }
}
