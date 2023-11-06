package lotto;

public class Validator {
    // 공백이거나 NULL인지 검증
    public static Boolean isBlankOrNULL(String input) {
        if (input.equals("") || input == null)
            throw new IllegalArgumentException("[ERROR]");

        return true;
    }

    // 공백문자를 포함하는지 검증
    public static Boolean containSpace(String input) {
        if (input.contains(" "))
            throw new IllegalArgumentException("[ERROR]");

        return true;
    }
}
