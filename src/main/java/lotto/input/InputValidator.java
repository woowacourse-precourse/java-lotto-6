package lotto.input;

import static lotto.error.message.InvalidInputErrorMessage.BONUS_NUMBER_IN_WINNING_NUMBER;
import static lotto.error.message.InvalidInputErrorMessage.OUT_OF_RANGE;
import static lotto.error.message.InvalidInputErrorMessage.PURCHASE_AMOUNT_UNDER_LOTTO_PRICE;
import static lotto.error.message.InvalidInputErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE;
import static lotto.error.message.InvalidInputErrorMessage.WINNING_NUMBERS_COUNT_NOT_MATCH;
import static lotto.error.message.InvalidInputErrorMessage.WINNING_NUMBERS_DUPLICATE;
import static lotto.global.Constant.LOTTO_MAX_NUMBER;
import static lotto.global.Constant.LOTTO_MIN_NUMBER;
import static lotto.global.Constant.LOTTO_NUMBERS_COUNT;
import static lotto.global.Constant.LOTTO_PRICE;

import java.util.HashSet;
import java.util.List;
import lotto.error.exception.InvalidInputException;
import lotto.util.IntegerUtil;

public class InputValidator {
    public void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE.getNumber()) {
            throw new InvalidInputException(PURCHASE_AMOUNT_UNDER_LOTTO_PRICE.getMessage());
        }
        if (purchaseAmount % LOTTO_PRICE.getNumber() != 0) {
            throw new InvalidInputException(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        checkWinningNumbersCountMatch(winningNumbers);

        for (Integer winningNumber : winningNumbers) {
            if (!IntegerUtil.checkNumberInRange(winningNumber, LOTTO_MIN_NUMBER.getNumber(),
                    LOTTO_MAX_NUMBER.getNumber())) {
                throw new InvalidInputException(OUT_OF_RANGE.getMessage());
            }
        }
        checkWinningNumberIsDuplicate(winningNumbers);
    }

    private void checkWinningNumbersCountMatch(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBERS_COUNT.getNumber()) {
            throw new InvalidInputException(WINNING_NUMBERS_COUNT_NOT_MATCH.getMessage());
        }
    }

    private void checkWinningNumberIsDuplicate(List<Integer> winningNumbers) {
        if (new HashSet<>(winningNumbers).size() != LOTTO_NUMBERS_COUNT.getNumber()) {
            throw new InvalidInputException(WINNING_NUMBERS_DUPLICATE.getMessage());
        }
    }

    public void validateBonusNumber(Integer bonusNumber, List<Integer> winningNumbers) {
        if (!IntegerUtil.checkNumberInRange(bonusNumber, LOTTO_MIN_NUMBER.getNumber(), LOTTO_MAX_NUMBER.getNumber())) {
            throw new InvalidInputException(OUT_OF_RANGE.getMessage());
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new InvalidInputException(BONUS_NUMBER_IN_WINNING_NUMBER.getMessage());
        }
    }
}
