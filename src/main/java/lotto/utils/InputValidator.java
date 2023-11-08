package lotto.utils;

import static lotto.utils.constants.ErrorMessageConstants.COMMA_POSITION_ERROR_MESSAGE;
import static lotto.utils.constants.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.utils.constants.ErrorMessageConstants.PURCHASE_AMOUNT_FORMAT_ERROR_MESSAGE;
import static lotto.utils.constants.ErrorMessageConstants.WINNING_NUMBER_FORMAT_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public void validateMainNumbers(String inputValue) {
        try {
            checkCommaPosition(inputValue);
            checkNumbersFormat(inputValue);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + WINNING_NUMBER_FORMAT_ERROR_MESSAGE);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + COMMA_POSITION_ERROR_MESSAGE);
        }

    }

    private void checkCommaPosition(String inputValue) {
        if (inputValue.startsWith(",") || inputValue.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumbersFormat(String inputValue) {
        List<String> numbers = new ArrayList<>(List.of(inputValue.split(",")));
        numbers.stream()
                .forEach((this::checkNumberFormat));
    }

    public void validateBonusNumber(String inputBonusNumber) {
        try {
            checkNumberFormat(inputBonusNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + WINNING_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public void validatePurchaseAmount(String inputAmount) {
        try {
            checkNumberFormat(inputAmount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + PURCHASE_AMOUNT_FORMAT_ERROR_MESSAGE);
        }
    }

    private void checkNumberFormat(String inputValue) {
        Integer.parseInt(inputValue);
    }

}
