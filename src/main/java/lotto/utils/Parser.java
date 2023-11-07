package lotto.utils;

import java.util.List;

public class Parser {
    private Parser() {
    }

    public static int parsePurchaseAmount(String userInput) throws IllegalArgumentException {
        int amount = tryParseInt(userInput);
        validatePositiveNumber(amount);
        return amount;
    }

    public static List<Integer> parseWinningNumbers(String userInput) {
        List<String> splitUserInput = List.of(userInput.split(","));

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
            throw new IllegalArgumentException("[ERROR] 입력된 값은 정수여야 합니다.");
        }
    }

    private static void validatePositiveNumber(int num) throws IllegalArgumentException {
        if (num <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 값은 양수여야 합니다.");
        }
    }
}
