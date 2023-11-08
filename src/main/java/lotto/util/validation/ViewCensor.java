package lotto.util.validation;

import static lotto.util.content.ErrorMessage.INPUT_COMMA_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_NUMERIC_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_SPACE_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_UNIT_ERROR;
import static lotto.util.content.ErrorMessage.UNIQUE_BONUS_ERROR;
import static lotto.util.rule.GameRule.TICKET_PRICE;

import lotto.domain.Lotto;

public class ViewCensor {

    public static void validateWinningNumber(String input) {
        space(input);
        comma(input);
        numeric(input.replaceAll(",", ""));
    }

    public static void validatePurchase(String input) {
        space(input);
        remainValue(input);
    }

    public static void validateBonusNumber(String input, Lotto number) {
        space(input);
        numeric(input);
        containUniqueValue(input, number);
    }

    private static void comma(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(INPUT_COMMA_ERROR.getContent());
        }
    }

    private static void remainValue(String input) {
        numeric(input);
        int numeric = Integer.parseInt(input);
        if (numeric % TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INPUT_UNIT_ERROR.getContent());
        }
    }

    private static void numeric(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException(INPUT_NUMERIC_ERROR.getContent());
        }
    }

    private static void space(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_SPACE_ERROR.getContent());
        }
    }

    public static void containUniqueValue(String input, Lotto numbers) {
        int number = Integer.parseInt(input);
        if (numbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException(UNIQUE_BONUS_ERROR.getContent());
        }
    }

}
