package lotto.money;

public class Money {
    private static final String WRONG_MONEY = "로또는 1000원씩 구매해야 합니다.";
    private static final String NOT_INTEGER = "금액은 정수로 입력하세요.";
    private static final String INVALID_RANGE_AMOUNT = "1000원 이상 입력하세요";
    private static final int LOTTO_PRICE = 1000;

    private Integer money;

    public Money(String amount) {
        this.money = validate(amount);
    }

    private Integer validate(String amount) {
        Integer money = checkIntegerAmount(amount);
        checkMinimumAmount(money);
        checkCorrectUnit(money);
        return money;
    }

    private Integer checkIntegerAmount(String amount) {
        try {
            return Integer.valueOf(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    private void checkMinimumAmount(Integer amount) {
        if (!isAmountBelowMinimum(amount)) {
            throw new IllegalArgumentException(INVALID_RANGE_AMOUNT);
        }
    }

    private boolean isAmountBelowMinimum(Integer amount) {
        return amount >= LOTTO_PRICE;
    }

    private void checkCorrectUnit(Integer money) {
        if (!isDivisibleByLottoPrice(money)) {
            throw new IllegalArgumentException(WRONG_MONEY);
        }
    }

    private boolean isDivisibleByLottoPrice(Integer money) {
        return money % LOTTO_PRICE == 0;
    }
}
