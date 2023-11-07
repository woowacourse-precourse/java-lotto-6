package lotto;

import static java.util.stream.Collectors.toList;
import static lotto.resource.TextResourceProvider.BONUS_NUMBER_CANNOT_CONVERT_TO_INTEGER_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_DELIMITER;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidPurchasedAmountException;
import lotto.exception.InvalidWinningNumbersException;

public class InputConverter {
    private InputValidator validator;

    public InputConverter(InputValidator validator) {
        this.validator = validator;
    }

    public long convertToPurchasedAmount(String input) {
        try {
            long purchasedAmount = Long.parseLong(input);
            validator.checkIfNegativeLong(purchasedAmount);
            validator.checkIfDivisibleByLotteryPrice(purchasedAmount);
            return purchasedAmount;
        } catch (NumberFormatException e) {
            throw new InvalidPurchasedAmountException(PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT,
                    input, e);
        }
    }

    public List<Integer> convertToWinningNumbers(String input) {
        try {
            List<Integer> tokens = Arrays.stream(input.split(INPUT_DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());
            validator.checkIfNumbersBetween(1, 45, tokens);
            validator.checkIfNumbersIs6UniqueNumbers(tokens);

            return tokens;
        } catch (NumberFormatException e) {
            throw new InvalidWinningNumbersException(
                    WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT, input, e);
        }
    }

    public int convertToBonusNumber(String input, List<Integer> numbers) {
        try {
            int bonusNumber = Integer.parseInt(input);
            validator.checkIfNumberBetween(1, 45, bonusNumber);
            validator.checkIfNumberIsInWinningNumber(bonusNumber, numbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new InvalidBonusNumberException(BONUS_NUMBER_CANNOT_CONVERT_TO_INTEGER_TEXT, input, e);
        }
    }
}
