package lotto.utils.validator;

import java.util.List;
import lotto.utils.parser.StringParser;
import lotto.utils.constant.Condition;
import lotto.utils.constant.ErrorMessage;

public class InputValidator {

    public void validatePurchaseCostInputView(String cost) {
        validateInputBlank(cost);
        validateInputInt(cost);
    }

    public void validateWinningNumberInputView(String number) {
        List<String> numberList = StringParser.splitString(number);
        validateInputBlank(number);
        validateWinningNumberSplitSize(numberList);
        validateWinningNumberDuplication(numberList);
        validateWinningNumberEach(numberList);
    }

    public void validateBonusNumberInputView(String number) {
        validateInputBlank(number);
        validateInputInt(number);
    }

    private void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateInputInt(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessage.INT_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateWinningNumberSplitSize(List<String> winningNumbers) {
        if (winningNumbers.size() != Condition.SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateWinningNumberOutOfRange(String winningNumber) {
        int winningNumberToInt = StringParser.parseStringToInt(winningNumber);
        if (winningNumberToInt < Condition.MIN_RANGE.getNumber()
                || winningNumberToInt > Condition.MAX_RANGE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateWinningNumberDuplication(List<String> winningNumbers) {
        List<String> distinctWinningNumbers = winningNumbers.stream().distinct().toList();
        if (winningNumbers.size() != distinctWinningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateWinningNumberEach(List<String> winningNumbers) {
        for (String number : winningNumbers) {
            validateInputInt(number);
            validateWinningNumberOutOfRange(number);
        }
    }
}
