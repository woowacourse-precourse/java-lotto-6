package lotto.view;

import java.util.List;

public class InputValidator {

    private static final String CHARACTER_ERROR_MESSAGE = "[ERROR] 문자를 입력할 수 없습니다.";

    private InputValidator() {
    }

    private static class InputValidatorHolder {
        private static InputValidator inputValidator = new InputValidator();
    }

    public static InputValidator getInstance() {
        return InputValidatorHolder.inputValidator;
    }

    public int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CHARACTER_ERROR_MESSAGE);
        }
    }

    public List<Integer> validateNumbers(List<String> input) {
        try {
            return input.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CHARACTER_ERROR_MESSAGE);
        }
    }
}
