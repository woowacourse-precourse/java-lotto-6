package utils;

public class Validator {
    private static final String STRING_TO_INTEGER_ERROR = "[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다.";
    private static final String INPUT_IS_EMPTY = "[ERROR] 입력 값이 없습니다.";

    public static void validateNumericValue(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(STRING_TO_INTEGER_ERROR);
        }
    }

    public static void validateIsEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY);
        }
    }
}
