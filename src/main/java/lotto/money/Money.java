package lotto.money;

public class Money {
    private static final String WRONG_MONEY = "로또는 1000원씩 구매해야 합니다.";
    private static final String NOT_INTEGER = "금액은 정수로 입력하세요.";
    private static final int LOTTO_PRICE = 1000;

    private Integer money;

    public Money(String money) {
        this.money = validate(money);
    }

    private Integer validate(String moneyEntered) {
        Integer money = checkIntegerMoney(moneyEntered);
        checkCorrectUnit(money);
        return money;
    }

    private Integer checkIntegerMoney(String money) {
        try {
            return Integer.valueOf(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
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
