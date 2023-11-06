package lotto.util;

import static lotto.util.constant.GameRule.LOTTO_SIZE;
import static lotto.util.constant.GameRule.TICKET_PRICE;
import static lotto.util.content.ErrorMessage.INPUT_NUMERIC_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_SPACE_ERROR;
import static lotto.util.content.ErrorMessage.INPUT_UNIT_ERROR;
import static lotto.util.content.ErrorMessage.LOTTO_SIZE_ERROR;

import java.util.List;

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

    public static String validatePurchaseAmount(String input) {
        validateCommonInput(input);
        validateNumericInput(input);
        return input;
    }

    public static String validateWinningNumbers(String input) {
        // TODO: 당첨번호 입력값 검증
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

}
