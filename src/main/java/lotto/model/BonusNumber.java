package lotto.model;

import java.util.List;

public class BonusNumber {
    private int bonusNumber;
    private static final String INVALID_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호가 유효하지 않습니다.";
    private static final String BONUS_IN_WINNING_NUMBERS_ERROR_MESSAGE = "[ERROR] 보너스 번호가 당첨 번호에 포함되었습니다.";
    private static final String BONUS_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.";

    public BonusNumber(String bonusNumber, List<Integer> winningNumber) {
        int parsedBonusNumber = parseBonusNumber(bonusNumber);
        checkBonusNumberInWinningNumbers(parsedBonusNumber, winningNumber);
        checkBonusNumberInRange(parsedBonusNumber);
        this.bonusNumber = parsedBonusNumber;
    }

    private int parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }

    private void checkBonusNumberInWinningNumbers(int bonusNumber, List<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_IN_WINNING_NUMBERS_ERROR_MESSAGE);
        }
    }

    private void checkBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
