package lotto.util.validation;

import static lotto.util.content.ErrorMessage.INPUT_COMMA_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_NUMERIC_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_SPACE_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_UNIT_ERROR;
import static lotto.util.content.ErrorMessage.LOTTO_RANGE_ERROR;
import static lotto.util.content.ErrorMessage.LOTTO_SIZE_ERROR;
import static lotto.util.content.ErrorMessage.UNIQUE_BONUS_ERROR;
import static lotto.util.content.ErrorMessage.UNIQUE_NUMBER_ERROR;
import static lotto.util.rule.GameRule.LOTTO_SIZE;
import static lotto.util.rule.GameRule.MAX_LOTTO_RANGE;
import static lotto.util.rule.GameRule.MIN_LOTTO_RANGE;
import static lotto.util.rule.GameRule.TICKET_PRICE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.domain.Lotto;

public class ViewCensor {

    public static void validateWinningNumber(String input) {
        space(input);
        comma(input);
        numeric(input.replaceAll(",", ""));
        sizeNumber(input);
        containUniqueNumber(input);
        rangeNumber(input);
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

    public static void containUniqueValue(String input, Lotto numbers) {
        int number = Integer.parseInt(input);
        if (numbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException(UNIQUE_BONUS_ERROR.getContent());
        }
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

    private static void rangeNumber(String input) {
        String[] numbers = input.split(",");
        for (String s : numbers) {
            int number = Integer.parseInt(s);
            if (!isValidLottoNumber(number)) {
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR.getContent());
            }
        }
    }

    private static void sizeNumber(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getContent());
        }
    }

    private static void containUniqueNumber(String input) {
        String[] bucket = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String target : bucket) {
            int number = Integer.parseInt(target);
            numbers.add(number);
        }
        if (hasUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(UNIQUE_NUMBER_ERROR.getContent());
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return number >= MIN_LOTTO_RANGE.getValue() && number <= MAX_LOTTO_RANGE.getValue();
    }

    private static boolean hasUniqueNumbers(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

}
