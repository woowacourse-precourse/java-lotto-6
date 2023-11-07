package lotto.utils;

public class NumberParser {
    private static String IMPROPER_NUMBER_MESSAGE = "숫자만 입력 가능합니다.";

    public static Integer parse(String inputNumber) {
        CommonValidator.validateEmptyString(inputNumber);
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IMPROPER_NUMBER_MESSAGE);
        }
    }
}
