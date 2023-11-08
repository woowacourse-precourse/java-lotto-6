package lotto.validator;

import static lotto.constant.ErrorMessage.DUPLICATED_NUMBER_ERROR;
import static lotto.constant.ErrorMessage.INCORRECT_INPUT_COUNT;
import static lotto.constant.ErrorMessage.INDIVISIBLE_PRICE_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorMessage.WRONG_TYPE_INPUT_ERROR;
import static lotto.constant.ErrorMessage.WRONG_TYPE_PRICE_ERROR;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public class InputValidator {

    public static void validateBudget(String inputBudget) {

        try {
            int budget = Integer.parseInt(inputBudget);

            if (budget % Lotto.PRICE != 0) {
                throw new IllegalArgumentException(INDIVISIBLE_PRICE_ERROR.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_TYPE_PRICE_ERROR.getMessage());
        }
    }

    public static void validateWinningNumber(String winningNumberInput) {

        List<String> numbers = Arrays.asList(winningNumberInput.split(","));

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INCORRECT_INPUT_COUNT.getMessage());
        }

        for (String number : numbers) {
            try {
                Integer parsedNumber = Integer.parseInt(number);
                validateRange(parsedNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(WRONG_TYPE_INPUT_ERROR.getMessage());
            }
        }

        validateDuplicate(numbers);
    }

    public static void validateBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {

        try {
            Integer bonusNumber = Integer.parseInt(bonusNumberInput);
            validateRange(bonusNumber);

            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_TYPE_INPUT_ERROR.getMessage());
        }
    }

    public static void validateRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public static void validateDuplicate(List<String> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR.getMessage());
        }
    }
}
