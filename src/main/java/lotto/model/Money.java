package lotto.model;

public class Money {
    private int money;

    public Money(String input) {
        isBlank(input);
        isNumeric(input);
        int money = parseInt(input);
        this.money = money;
    }

    private void isBlank(String money) {
        if (money.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값을 입력하면 안됩니다.");
        }
    }

    private void isNumeric(String money) {
        if (money.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }
    }

    private int parseInt(String money) {
        return Integer.parseInt(money);
    }
}
