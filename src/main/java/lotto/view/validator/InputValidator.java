package lotto.view.validator;

import java.util.regex.Pattern;

public class InputValidator {

    private InputValidator() {

    }

    public static void validateLottoNumberInput(String input) {
        try {
            validateIsEmpty(input);
            validateIsRightFormat(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void validateIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }

    private static void validateIsRightFormat(String input) {
        if (isRightFormat(input)) {
            throw new IllegalArgumentException("입력값은 쉼표(,)를 기준으로 구분되어야 합니다.");
        }
    }

    private static boolean isRightFormat(String input) {
        String regex = "^\\d+(,\\d+)*$";
        return Pattern.compile(regex)
                .matcher(input)
                .matches();
    }
}
