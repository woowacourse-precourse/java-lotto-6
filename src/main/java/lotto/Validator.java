package lotto;

public class Validator {
    public Boolean validate(String input) {
        if (isBlankOrNULL(input))
            throw new IllegalArgumentException("[ERROR]");

        if (containSpace(input))
            throw new IllegalArgumentException("[ERROR]");

        return true;
    }

    // 공백이거나 NULL인지 검증
    private Boolean isBlankOrNULL(String input) {
        if (input.equals("") || input == null)
            return true;

        return false;
    }

    // 공백문자를 포함하는지 검증
    private Boolean containSpace(String input) {
        if (input.contains(" "))
            return true;

        return false;
    }
}
