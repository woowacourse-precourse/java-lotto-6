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

    public static Money of(NumericString numericString) {
        return of(Integer.valueOf(numericString.getNumericString()));
    }

    public Integer calcBillCount() {
        return money / MINIMUM_AMOUNT;
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

    static public class NumericString {

        private final String numericString;

        public NumericString(String numericString) {
            validateBlink(numericString);
            validateNumeric(numericString);
            this.numericString = numericString.trim();
        }

        public String getNumericString() {
            return numericString;
        }

        private static void validateBlink(String numericString) {
            if (isEmpty(numericString)) {
                throw new IllegalArgumentException("빈 문자를 입력하지 말아주세요");
            }
        }

        private static boolean isEmpty(String numericString) {
            return numericString.isEmpty();
        }

        private static void validateNumeric(String numericString) {
            if (isNotNumeric(numericString.trim())) {
                throw new IllegalArgumentException("숫자만 입력해주세요");
            }
        }

        private static boolean isNotNumeric(String numericString) {
            return !numericString.chars().allMatch(Character::isDigit);
        }
    }
}
