package lotto.model;

public class Money {
    private int won;

    public Money(String input) {
        isBlank(input);
        isNumeric(input);
        int money = parseInt(input);
        this.won = money;
    }

    private void isBlank(String money) {
        if (money.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력하면 안됩니다.");
        }
    }

    private void isNumeric(String money) {
        if (!money.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
    }

    private int parseInt(String money) {
        return Integer.parseInt(money);
    }

    public int getMoney() {
        return this.won;
    }

    public void validateDivideBy1000() {
        if (won % 1000 != 0) {
            throw new IllegalArgumentException("1000 단위의 금액이 아닙니다.");
        }
    }
}
