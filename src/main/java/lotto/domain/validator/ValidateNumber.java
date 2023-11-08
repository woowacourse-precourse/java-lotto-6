package lotto.domain.validator;

public class ValidateNumber {

    private static final String DIGIT = "\\d+";
    private static final String ERROR_HEAD = "[ERROR] ";
    private static final String ERROR_ONLY_NUMBER = "숫자만 입력 해주세요.";

    public static void isNumber(String number) {
        if (number.matches(DIGIT)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_HEAD + ERROR_ONLY_NUMBER);
    }
}
