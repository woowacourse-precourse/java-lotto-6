package lotto.utils;

public class InputValidator {

    public static String validate(String input) {
        if (IsNull(input)) {
            throw new NullPointerException("[ERROR] 사용자의 입력이 null 입니다.");
        }
        if (IsEmptyString(input)) {
            throw new IllegalArgumentException("[ERROR] 사용자의 입력이 비어있습니다.");
        }
        if (isBlankString(input)) {
            throw new IllegalArgumentException("[ERROR] 사용자의 입력이 공백입니다.");
        }
        return input;
    }

    private static boolean IsEmptyString(String input) {
        return input.isEmpty();
    }

    private static boolean IsNull(String input) {
        return input == null;
    }

    private static boolean isBlankString(String input) {
        return input.isBlank();
    }
}
