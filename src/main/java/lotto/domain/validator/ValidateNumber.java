package lotto.domain.validator;

public class ValidateNumber {

    private static final String DIGIT = "\\d+";

    public static void isNumber(String number) {
        if (number.matches(DIGIT)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력 해주세요.");
    }
}
