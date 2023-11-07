package lotto.util;

public class Validation {
    private static final String INPUT_NOT_NUMBER = "[ERROR] 숫자가 아닌 다른 값이 입력되었습니다.";
    private static final String INPUT_NOT_WINNIG_NUMBERS_REGEX = "[ERROR] 당첨 번호는 구분 쉼표(,)를 기준으로 숫자 6개를 입력해야 합니다.";

    public static void validateIsNotNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER);
        }
    }

    public static void validateWinningNumbersWithRegex(String input) {
        if (!input.matches("^\\d{1,2}(,\\d{1,2}){5}$")) {
            throw new IllegalArgumentException(INPUT_NOT_WINNIG_NUMBERS_REGEX);
        }
    }
}
