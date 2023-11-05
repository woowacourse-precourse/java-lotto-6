package lotto.domain;

public class Money {

    private final Integer money;
    private final static Integer MINIMUM_AMOUNT = 1000;

    private Money(Integer money) {
        validateRemainMoney(money);
        validateMinimumAmount(money);
        this.money = money;
    }

    public static Money of(Integer money) {
        return new Money(money);
    }

    public static Money of(String money) {
        validateNumeric(money);
        return of(Integer.valueOf(money.trim()));
    }

    public Integer calcBillCount() {
        return money / MINIMUM_AMOUNT;
    }

    private static void validateNumeric(String money) {
        if (isNotNumeric(money.trim())) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }

    private static boolean isNotNumeric(String money) {
        return !money.chars().allMatch(Character::isDigit);
    }

    private void validateMinimumAmount(Integer money) {
        if (isMin(money)) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    private boolean isMin(Integer money) {
        return money < MINIMUM_AMOUNT;
    }

    private void validateRemainMoney(Integer money) {
        if (hasRemain(money)) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    private boolean hasRemain(Integer money) {
        return money % MINIMUM_AMOUNT != 0;
    }
}
