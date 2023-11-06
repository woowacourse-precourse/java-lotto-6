package lotto.view;

import java.util.Arrays;

public class InputValidator {

    public static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIntegerArray(String[] input) {
        try {
            Arrays.stream(input).map(Integer::parseInt).close();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
