package lotto.validation;

public class BonusNumberInputValidator {
    private static final String ZERO_EXCEPTION_MESSAGE = "입력값이 0이 될 수 없습니다.";
    private static final String NON_DIGIT_EXCEPTION_MESSAGE = "입력값이 숫자가 아닙니다.";

    public static void validate(String bonusNumber) {
        checkInputZero(bonusNumber);
        checkInputDigit(bonusNumber);
    }

    private static void checkInputZero(String bonusNumber) {
        if (bonusNumber.equals("0")) {
            throw new IllegalArgumentException(ZERO_EXCEPTION_MESSAGE);
        }
    }

    private static void checkInputDigit(String bonusNumber) {
        for (int i = 0; i < bonusNumber.length(); i++) {
            if (!Character.isDigit(bonusNumber.charAt(i))) {
                throw new IllegalArgumentException(NON_DIGIT_EXCEPTION_MESSAGE);
            }
        }
    }
}
