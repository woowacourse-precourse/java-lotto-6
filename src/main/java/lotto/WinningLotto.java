package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber() {
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
