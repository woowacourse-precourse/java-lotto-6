package lotto.view.validation;

public class InputValidation {

    public static String inputValidate(String input) {
        validateEmpty(input);
        validateBlank(input);
        return input;
    }

    private static void validateEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 빈칸은 입력될 수 없습니다.");
        }
    }

    private static void validateBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력될 수 없습니다.");
        }
    }
}
