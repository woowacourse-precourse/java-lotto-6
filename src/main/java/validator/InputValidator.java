package validator;

import java.util.Arrays;
import java.util.List;
import lotto.Unit;
import message.ErrorMessage;
import message.Symbol;

public class InputValidator {

    public static void validatePurchaseAmountInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE.getMessage());
        }
        int amount = Integer.parseInt(input);
        if (amount < Unit.PURCHASE_AMOUNT_UNIT.getUnit() ||
                amount % Unit.PURCHASE_AMOUNT_UNIT.getUnit() != Unit.ZERO.getUnit()) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    public static void validateWinningNumbersInput(String input) {
        String[] winningNumbers = input.split(Symbol.COMMA.getSymbol());
        if (!isValidLengthOfWinningNumbersInput(winningNumbers) ||
                !containsAllNumericInput(winningNumbers) ||
                !isUniqueWinningNumbersInput(winningNumbers) ||
                !numbersInRange(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    public static void validateBonusNumberInput(String input, List<Integer> winningNumbers) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        }
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < Unit.LOTTERY_MINIMUM_NUMBER.getUnit() ||
                Unit.LOTTERY_MAXIMUM_NUMBER.getUnit() < bonusNumber) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    private static boolean isValidLengthOfWinningNumbersInput(String[] winningNumbers) {
        if (winningNumbers.length != Unit.LOTTERY_NUMBER_COUNT.getUnit()) {
            return false;
        }
        return true;
    }

    private static boolean containsAllNumericInput(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            try {
                Integer.parseInt(winningNumber);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUniqueWinningNumbersInput(String[] winningNumbers) {
        int count = (int) Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .distinct()
                .count();
        if (count != Unit.LOTTERY_NUMBER_COUNT.getUnit()) {
            return false;
        }
        return true;
    }

    private static boolean numbersInRange(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .allMatch(number -> Unit.LOTTERY_MINIMUM_NUMBER.getUnit() <= number &&
                        number <= Unit.LOTTERY_MAXIMUM_NUMBER.getUnit());
    }
}
