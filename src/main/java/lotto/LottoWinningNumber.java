package lotto;

import java.util.List;

public class LottoWinningNumber {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers);
        validateBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("Bonus number must be between 1 and 45.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
