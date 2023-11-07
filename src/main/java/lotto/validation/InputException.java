package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class InputException {
    public static void blankInput(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] Blank Input");
        }
    }

    public static void notNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] Not a Number");
        }
    }

    public static void underThousand(final String input) {
        if (Integer.parseInt(input) < 1000) {
            throw new IllegalArgumentException("[ERROR] Under Thousand");
        }
    }

    public static void notMultipleOfThousand(final String input) {
        if ((Integer.parseInt(input) % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] Not a Multiple of Thousand");
        }
    }

    public static void onlyComma(final String input) {
        if (input.matches("^,.*") || input.matches(".*,$")) {
            throw new IllegalArgumentException("[ERROR] Only Comma input");
        }
    }

    public static void cannotParseToInt(final String input) {
        try {
            for (String number : input.split(",")) {
                Integer.parseInt(number);
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] Cannot Parse To Int");
        }
    }

    public static void notSixNumberInput(final List<Integer> input) {
        if (input.size() != 6) {
            throw new IllegalArgumentException("[ERROR] Not 6 input count provided");
        }
    }

    public static void wrongNumberRange(final List<Integer> input) {
        for (int number : input) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] Numbers should be between 1 and 45");
            }
        }
    }

    public static void numberDuplicate(final List<Integer> input) {
        final Set<Integer> uniqueNumbers = new HashSet<>(input);

        if (uniqueNumbers.size() < input.size()) {
            throw new IllegalArgumentException("[ERROR] Duplicate numbers are not allowed");
        }
    }

    public static void wrongNumberRange(final String input) {
        final int number = Integer.parseInt(input);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] Numbers should be between 1 and 45");
        }
    }

    public static void isDuplicatedWithWinningNumbers(final String input, final List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException("[ERROR] Duplicated with Winning Numbers are not Allowed");
        }
    }
}
