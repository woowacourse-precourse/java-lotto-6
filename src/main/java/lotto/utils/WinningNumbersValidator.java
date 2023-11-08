package lotto.utils;

public class WinningNumbersValidator {
    public static void validate(String input) {
        validIsStartWithComma(input);
        validIsEndWithComma(input);
    }

    public static void validDigitIsInt(String digit) {
        try {
            Integer.parseInt(digit);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 각 요소는 숫자여야 합니다.");
        }
    }
    private static void validIsStartWithComma(String input) {
        if (input.startsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 ,로 시작하면 안됩니다.");
        }
    }

    private static void validIsEndWithComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 ,로 끝나면 안됩니다.");
        }
    }


}
