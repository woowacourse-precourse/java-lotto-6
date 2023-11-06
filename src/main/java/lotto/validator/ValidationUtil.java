package lotto.validator;

public class ValidationUtil {
    public static boolean isNumber(String str) {
        if (str.isEmpty()) {
            return false;
        }

        if (str.charAt(0) == '-') {
            return str.length() > 1 && str.substring(1).chars().allMatch(Character::isDigit);
        }

        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean isInputFirstZero(String str) {
        return str.charAt(0) == '0';
    }
}
