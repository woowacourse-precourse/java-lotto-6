package lotto.validate;

public class Validator {
    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean isMultipleOf1000(int money) {
        return money % 1000 == 0;
    }

    public static boolean isThousandOrMore(int number) {
        return number >= 1000;
    }
}
