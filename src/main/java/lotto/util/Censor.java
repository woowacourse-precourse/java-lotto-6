package lotto.util;

import static lotto.util.rule.GameRule.LOTTO_SIZE;
import static lotto.util.rule.GameRule.MAX_LOTTO_RANGE;
import static lotto.util.rule.GameRule.MIN_LOTTO_RANGE;
import static lotto.util.rule.GameRule.TICKET_PRICE;
import static lotto.util.content.ErrorMessage.INPUT_COMMA_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_NUMERIC_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_SPACE_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_UNIT_ERROR;
import static lotto.util.content.ErrorMessage.LOTTO_RANGE_ERROR;
import static lotto.util.content.ErrorMessage.LOTTO_SIZE_ERROR;
import static lotto.util.content.ErrorMessage.UNIQUE_BONUS_ERROR;
import static lotto.util.content.ErrorMessage.UNIQUE_NUMBER_ERROR;

import java.util.HashSet;
import java.util.List;
import lotto.domain.Lotto;

public class Censor {

    public static void validateLotto(List<Integer> numbers) {
        if (!isValidLottoNumberSize(numbers)) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getContent());
        }

        if (!hasUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(UNIQUE_NUMBER_ERROR.getContent());
        }
    }

    public static void validatePurchaseUnit(Integer money) {
        if (money % TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INPUT_UNIT_ERROR.getContent());
        }
    }

    public static void validateAnnouncementNumber(List<Integer> numbers) {
        if (!hasUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(UNIQUE_NUMBER_ERROR.getContent());
        }

        if (numbers.stream().anyMatch(number -> !isValidLottoNumber(number))) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR.getContent());
        }
    }

    public static void validateUniqueBonusNumber(Integer input, Lotto numbers) {
        if (numbers.getNumbers().contains(input)) {
            throw new IllegalArgumentException(UNIQUE_BONUS_ERROR.getContent());
        }
    }

    public static String validateBasicInput(String input) {
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

    private static boolean hasUniqueNumbers(List<Integer> numbers) {
        return numbers.size() == new HashSet<>(numbers).size();
    }

    private static boolean isValidLottoNumberSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_SIZE.getValue();
    }

    private static boolean isValidLottoNumber(int number) {
        return number >= MIN_LOTTO_RANGE.getValue() && number <= MAX_LOTTO_RANGE.getValue();
    }

}
