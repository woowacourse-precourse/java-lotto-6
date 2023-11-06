package lotto.model;

public class Money {
    private final String money;

    public Money(String money) {
        validateMoney(money);
        this.money = money;
    }

    private static void validateMoney(String money) {
        isInteger(money);
    }

    private static void isInteger(String money) {
        if (!money.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }


}
