package lotto;

public class Validator {
    public Boolean validate(String input) {
        if (isSpaceOrNULL(input))
            throw new IllegalArgumentException("[ERROR]");

        return true;
    }

    // 공백이거나 NULL인지 검증
    private Boolean isSpaceOrNULL(String input) {
        if (input.equals("") || input == null)
            return true;

        return false;
    }
}
