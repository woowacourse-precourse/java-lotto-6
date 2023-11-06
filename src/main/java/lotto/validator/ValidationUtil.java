package lotto.validator;

public class ValidationUtil {
    public static boolean isNumber(String input) {
        if (input.isEmpty()) {
            return false;
        }

        if (input.charAt(0) == '-') {
            return input.length() > 1 && input.substring(1).chars().allMatch(Character::isDigit);
        }

        return input.chars().allMatch(Character::isDigit);
    }

    public static boolean isInputFirstZero(String input) {
        return input.charAt(0) == '0';
    }
}
