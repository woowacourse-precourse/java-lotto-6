package lotto.validator;

public class AmountValidator {
    public static void validateAmount(int money) {
        AmountValidator.validateZero(money);
        AmountValidator.validatePayAble(money);
    }
    private static void validateZero(int money) {
        if (money == 0) {
            throw new IllegalArgumentException("금액은 0을 입력할 수 없습니다.");
        }
    }

    private static void validatePayAble(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000 단위로만 입력 가능합니다.");
        }
    }
}
