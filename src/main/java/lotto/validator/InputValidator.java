package lotto.validator;

public class InputValidator {

    private InputValidator() {
        throw new AssertionError("인스턴스화 불가능");
    }

    public static void validateMoney(String money) {
        if (isNotDigit(money)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (isOverMax(money)) {
            throw new IllegalArgumentException("입력할 수 있는 금액의 최댓값 그 이상입니다.");
        }
    }

    public static void validateBonusNumber(String number) {
        if (isNotDigit(number)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static boolean isNotDigit(String number) {
        return !number.matches("^[0-9]+$");
    }

    private static boolean isOverMax(String money) {
        return Long.parseLong(money) > (Long.MAX_VALUE / 1000L) * 1000L;
    }

}
