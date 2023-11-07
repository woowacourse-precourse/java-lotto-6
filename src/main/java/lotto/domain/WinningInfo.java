package lotto.domain;

import lotto.constant.Message;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningInfo {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void saveWinningNumbers(List<Integer> winningNumbers) {

        validateSize(winningNumbers);
        validateRange(winningNumbers);
        validateDuplication(winningNumbers);

        this.winningNumbers = winningNumbers;
    }

    public void saveBonusNumber(int bonusNumber) {

        checkDuplicateBonusNumber(bonusNumber);
        validateRange(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateSize(List<Integer> winningNumbers) {

        if (winningNumbers.size() != 6) {

            throw new IllegalArgumentException(Message.WINNING_NUMBERS_SIZE_ERROR_MESSAGE.name());
        }
    }

    private void validateRange(List<Integer> winningNumbers) {

        for (int number : winningNumbers) {

            if (number < 1 || number > 45) {

                throw new IllegalArgumentException(Message.WINNING_NUMBERS_OVER_RANGE_ERROR_MESSAGE.name());
            }
        }
    }

    private void validateDuplication(List<Integer> winningNumbers) {

        Set<Integer> set = new HashSet<>(winningNumbers);

        if (set.size() != 6) {

            throw new IllegalArgumentException(Message.WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE.name());
        }
    }

    private void checkDuplicateBonusNumber(int bonusNumber) {

        List<Integer> numbers = getWinningNumbers();

        for (int num : numbers) {

            if (num == bonusNumber) {

                throw new IllegalArgumentException(Message.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE.name());
            }
        }
    }

    private void validateRange(int bonusNumber) {

        if (bonusNumber < 1 || bonusNumber > 45) {

            throw new IllegalArgumentException(Message.BONUS_NUMBERS_OVER_RANGE_ERROR_MESSAGE.name());
        }
    }

    public List<Integer> getWinningNumbers() {

        return winningNumbers;
    }

    public int getBonusNumber() {

        return bonusNumber;
    }
}
