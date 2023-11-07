package lotto.Model.Domain;

import java.util.List;

public class Raffle {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Raffle(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
