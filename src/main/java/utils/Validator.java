package utils;

public class Validator {
    public static void validateNumericValue(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 유효한 숫자가 아닙니다.");
        }
    }

    public static void validateIsEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }
}
