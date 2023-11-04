package lotto.domain.util.validator;

public class InputValidator {
    private static final char COMMA = ',';

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 수를 입력해야 합니다.");
        }
    }

    public static void validateNumberOrComma(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && c != COMMA) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호를 쉼표로 구분하여 입력해야 합니다.");
            }
        }
    }
}
