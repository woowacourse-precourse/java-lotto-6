package lotto.utils;

public class InputValidator {
    public static void validatePayNumber(String pay) {
        checkNumber(pay);
        checkNegativeNumber(pay);
    }

    public static void validateWinningNumber(String input) {
        checkDelimStartOrEnd(input);
        checkConsecutiveDelim(input);
        checkWhitespace(input);

        String[] numbers = input.split(",");
        for (String number : numbers) {
            checkNumber(number);
            checkLottoRange(number);
        }
    }

    private static void checkNumber(String number) {
        int intValue = 0;
        try {
            intValue = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void checkNegativeNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkDelimStartOrEnd(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkConsecutiveDelim(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkWhitespace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkLottoRange(String number) {
        if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
            throw new IllegalArgumentException();
        }
    }
}
