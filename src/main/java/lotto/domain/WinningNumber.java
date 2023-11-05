package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = applyLottoRules(winningNumber);
        isDifferentOne(bonusNumber);
        isInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    private List<Integer> applyLottoRules(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void isDifferentOne(int bonusNumber) {
        if (this.winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void isInRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
}
