package lotto.Input;

public class RangeCheck {

    static final int LOWER_BOUND = 1;
    static final int UPPER_BOUND = 45;

    public static void validateRange(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) < LOWER_BOUND || Integer.parseInt(input) > UPPER_BOUND) {
            throw new NumberFormatException();
        }
    }
}
