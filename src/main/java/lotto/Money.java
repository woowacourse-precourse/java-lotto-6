package lotto;

public class Money {
    private final int money;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        if (isInvalidType(money)) {
            throw new IllegalArgumentException("구입 금액은 숫자여야 합니다.");
        }
    }

    private boolean isInvalidType(String money) {
        try {
            Integer.parseInt(money);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
