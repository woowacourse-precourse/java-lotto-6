package lotto;

import java.util.List;

import static lotto.RunnerLotto.*;


public class ErrorCheck {
    public static void validateWinningNumbersSize(String[] winningNumbers) {
        if (winningNumbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_PROPER_SIZE_EXCEPTION.getMessage());
        }
    }
    public static void validateInputDataType(String winningLotteryNumber) {
        if (!(winningLotteryNumber.matches("^[0-9, ]+$"))) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_PROPER_DATA_TYPE_EXCEPTION.getMessage());
        }
    }
    public static void validateBonusNum(int bonusNum) {
        if (!(bonusNum >= LOTTO_START_NUMBER && bonusNum <= LOTTO_END_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_PROPER_BONUSNUMBER_RANGE.getMessage());
        }
    }

    public static void validateWinningNumbersDataType(String[] winningNumbers) {
        for (int check = 0; check < winningNumbers.length; check++) {
            if (winningNumbers[check].equals("")) {
                throw new IllegalArgumentException(ExceptionMessage.NO_COMMA_EXCEPTION.getMessage());
            }
            if (!(Integer.parseInt(winningNumbers[check]) >= LOTTO_START_NUMBER
                    && Integer.parseInt(winningNumbers[check]) <= LOTTO_END_NUMBER)) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_RANGE_EXCEPTION.getMessage());
            }
        }
    }

    public static void validatePurchaseInput(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_PROPER_PURCHASE_INPUT.getMessage());
        }
    }
    public static void validatePurchaseInputDataType(String purchaseAmountInput) {
        if (!(purchaseAmountInput.matches("^[0-9, ]+$"))){
            throw new IllegalArgumentException(ExceptionMessage.NOT_PROPER_PURCHASE_INPUT_DATA_TYPE.getMessage());
        }
    }

    public static void validateRandomLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_PROPER_LOTTO_NUMBER.getMessage());
        }
    }
}
