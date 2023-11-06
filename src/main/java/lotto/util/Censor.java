package lotto.util;

import static lotto.util.constant.GameRule.LOTTO_SIZE;
import static lotto.util.constant.GameRule.MAX_LOTTO_RANGE;
import static lotto.util.constant.GameRule.MIN_LOTTO_RANGE;
import static lotto.util.constant.GameRule.TICKET_PRICE;
import static lotto.util.content.ErrorMessage.INPUT_COMMA_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_NUMERIC_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_SPACE_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_UNIT_ERROR;
import static lotto.util.content.ErrorMessage.LOTTO_RANGE_ERROR;
import static lotto.util.content.ErrorMessage.LOTTO_SIZE_ERROR;
import static lotto.util.content.ErrorMessage.UNIQUE_NUMBER_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Censor {

    public static void validateLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getContent());
        }
    }

    public static void validatePurchaseUnit(Integer money) {
        if (money % TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INPUT_UNIT_ERROR.getContent());
        }
    }

    public static void validateAnnouncementNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(UNIQUE_NUMBER_ERROR.getContent());
        }

        if (numbers.stream().anyMatch(number -> number <= MIN_LOTTO_RANGE.getValue()
                || number >= MAX_LOTTO_RANGE.getValue())) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR.getContent());
        }
    }

    public static String validatePurchaseAmount(String input) {
        validateCommonInput(input);
        validateNumericInput(input);
        return input;
    }

    public static String validateWinningNumbersInput(String input) {
        validateCommonInput(input);
        validateCommaInput(input);
        validateNumericInput(input.replaceAll(",", ""));
        return input;
    }

    private static void validateCommonInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_SPACE_ERROR.getContent());
        }

        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_SPACE_ERROR.getContent());
        }
    }

    private static void validateNumericInput(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException(INPUT_NUMERIC_ERROR.getContent());
        }
    }

    private static void validateCommaInput(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(INPUT_COMMA_ERROR.getContent());
        }
    }

}
