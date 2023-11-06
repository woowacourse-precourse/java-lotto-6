package lotto.view;

public class InputValidator {
    static int validateAndParseInput(String input) {
        validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    private static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력에 숫자가 아닌 문자가 포함되어 있거나 숫자가 너무 큽니다.");
        }
    }
}