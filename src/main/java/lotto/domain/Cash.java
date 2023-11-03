package lotto.domain;

public class Cash {

    private static final Integer UNIT = 1000;
    private static final Integer ZERO = 0;
    private final Integer amount;

    public Cash(final Integer amount) {
        validateAvailableAmount(amount);
        validateAvailableCash(amount);
        this.amount = amount;
    }

    private void validateAvailableAmount(Integer amount) {
        if (amount < UNIT) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하셔야 합니다.");
        }
    }


    private void validateAvailableCash(Integer amount) {
        int remainder = amount % UNIT;
        if (remainder != ZERO) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 금액을 입력하셔야 합니다.");
        }
    }


}
