package lotto.function;

import lotto.constant.ErrorMessage;

import java.util.stream.Stream;

public class ValidationFunction {

    public int validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_WRONG);
        }
        return money;
    }

    public void validateWinningNumberSize(String[] winningNumbers) {
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE);
        }
    }

    public void validateWinningNumberRange(String[] winningNumbers) {
        for (int i = 0; i < 6; i++) {
            int compareNum = Integer.parseInt(winningNumbers[i]);
            if (compareNum < 1 || compareNum > 45) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE);
            }
        }
    }

    public void validateWinningNumberDuplicate(String[] winningNumbers) {
        Long winningNumbersSize = Stream.of(winningNumbers).distinct().count();
        if (winningNumbersSize != winningNumbers.length) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_DUPLICATE);
        }
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE);
        }
    }
}
