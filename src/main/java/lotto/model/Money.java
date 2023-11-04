package lotto.model;

public class Money {

    private final String NUMBER_PATTERN = "\\d+";
    private final int CURRENT_UNIT = 1000;

    private int money;

    public Money(String input) {
        isNumeric(input);
        money = Integer.parseInt(input);
        isPositive();
        isModEqualZero();
    }

    public int getMoney() {
        return money;
    }

    private void isNumeric(String target) {
        if (!target.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
    }

    private void isPositive() {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 양의 정수만 입력하세요.");
        }
    }

    private void isModEqualZero() {
        if (money % CURRENT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 " + CURRENT_UNIT + "으로 나누어 떨어져야 합니다.");
        }
    }
}
