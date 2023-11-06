package lotto;

import java.util.List;

public class LottoWinningNumber {

    private List<Integer> winningNumbers;
    private int bounsNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bounsNumber) {
        validate(winningNumbers);
        validateBonusNumber(bounsNumber);
        this.winningNumbers = winningNumbers;
        this.bounsNumber = bounsNumber;
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateBonusNumber(int bounsNumber) {
        if (bounsNumber < 1 || bounsNumber > 45) {
            throw new IllegalArgumentException("Bonus number must be between 1 and 45.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBounsNumber() {
        return bounsNumber;
    }
}
