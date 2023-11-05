package lotto.model;

public class Money {

    private final Integer money;

    public Money(Integer money) {
        validateOverZero(money);
        validateWonUnit(money);
        this.money = money;
    }

    private void validateOverZero(Integer money) {
        if (isOverMinimum(money)) {
            throw new IllegalArgumentException("[ERROR] 돈은 1,000원 이상 입력가능합니다.");
        }
    }

    private void validateWonUnit(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 1,000원 단위로 입력가능합니다.");
        }
    }

    private static boolean isOverMinimum(Integer money) {
        return money < 1000;
    }
}
