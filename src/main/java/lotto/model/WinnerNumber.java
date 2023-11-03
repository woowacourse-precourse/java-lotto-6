package lotto.model;

import java.util.List;
import lotto.constant.ValidateMessage;

public class WinnerNumber {
    private final List<Integer> winnerNumbers;

    public WinnerNumber(List<Integer> winnerNumbers) {
        isSizeEqualToSix(winnerNumbers);
        isBetween1And45(winnerNumbers);
        isDuplicate(winnerNumbers);
        this.winnerNumbers = winnerNumbers;
    }

    private void isSizeEqualToSix(List<Integer> winnerNumbers) {
        if (winnerNumbers.size() != 6) {
            ValidateMessage.WINNER_NUMBER_IS_NOT_SIZE_EQUAL_TO_SIX.throwException();
        }
    }

    private void isBetween1And45(List<Integer> winnerNumbers) {
        for (Integer winnerNumber : winnerNumbers) {
            if (winnerNumber < 1 || winnerNumber > 45) {
                ValidateMessage.WINNER_NUMBER_IS_BETWEEN_1_TO_45.throwException();
            }
        }
    }

    private void isDuplicate(List<Integer> winnerNumbers) {
        long count = winnerNumbers.stream().distinct().count();
        if (count != winnerNumbers.size()) {
            ValidateMessage.WINNER_NUMBER_IS_DUPLICATE.throwException();
        }
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }
}
