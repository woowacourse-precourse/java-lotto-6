package lotto.validate;

public class Validator {
    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
