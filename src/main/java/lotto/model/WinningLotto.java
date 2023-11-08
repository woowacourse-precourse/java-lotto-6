package lotto.model;

public class WinningLotto {
    private final WinningNumbers winningNumbers;
    private final Integer bonusNumber;

    public WinningLotto(WinningNumbers winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public NumberStatus judgeNumber(Integer number) {
        if (winningNumbers.hasNumber(number)) {
            return NumberStatus.CORRECT;
        }
        if (bonusNumber.equals(number)) {
            return NumberStatus.BONUS;
        }
        return NumberStatus.NOTHING;
    }
}
