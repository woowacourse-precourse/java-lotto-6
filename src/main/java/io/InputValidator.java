package io;

import java.util.List;

import static io.message.InputErrorMessage.*;
import static lotto.constant.LottoProperty.*;

public class InputValidator {

    public void validateLottoPurchaseAmount(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(BELOW_MIN_PURCHASE_AMOUNT.getMessage());
        }
        if (lottoPurchaseAmount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_PRICE.getMessage());
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
        if (winningNumbers.stream().distinct().count() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }

        for (int number : winningNumbers) {
            if (number < MIN_LOTTO_NUMBER.getValue() || number > MAX_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
            }
        }
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < MIN_LOTTO_NUMBER.getValue() || bonusNumber > MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}
