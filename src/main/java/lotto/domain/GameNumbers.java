package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ErrorMessage;

public class GameNumbers {
    private static final int WINNING_NUMBERS_LENGTH = 6;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private GameNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static GameNumbers of(List<Integer> winningNumbers, int bonusNumber) {
        validateListSize(winningNumbers);
        validateListDuplication(winningNumbers);
        validateNumberInList(winningNumbers, bonusNumber);
        return new GameNumbers(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static void validateListSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_LENGTH) {
            ErrorMessage.listSizeError(WINNING_NUMBERS_LENGTH);
            throw new IllegalArgumentException();
        }
    }

    private static void validateListDuplication(List<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);
        if (winningNumbers.size() != set.size()) {
            ErrorMessage.listDuplicationError();
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberInList(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            ErrorMessage.numberInListError(bonusNumber);
            throw new IllegalArgumentException();
        }
    }
}