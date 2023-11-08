package lotto.utils;

import static lotto.constants.ErrorMessage.INTEGER_REQUIRED;
import static lotto.constants.ErrorMessage.POSITIVE_REQUIRED;

import java.util.List;

public class Parser {
    public static final String WINNING_NUMBERS_SEPARATOR = ",";

    private Parser() {
    }

    public static int parsePurchaseAmount(String userInput) throws IllegalArgumentException {
        int amount = tryParseInt(userInput);
        validatePositiveNumber(amount);
        return amount;
    }

    public static List<Integer> parseWinningNumbers(String userInput) {
        List<String> splitUserInput = List.of(userInput.split(WINNING_NUMBERS_SEPARATOR));

        return splitUserInput.stream()
                .map(String::trim)
                .map(Parser::tryParseInt)
                .toList();
    }

    public static int parseBonusNumber(String userInput) {
        return tryParseInt(userInput);
    }

    private static int tryParseInt(String userInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_REQUIRED.getMessage());
        }
    }

    private static void validatePositiveNumber(int num) throws IllegalArgumentException {
        if (num <= 0) {
            throw new IllegalArgumentException(POSITIVE_REQUIRED.getMessage());
        }
    }
}
