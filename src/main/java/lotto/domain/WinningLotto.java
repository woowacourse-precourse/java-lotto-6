package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.numbers = createWinningLotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Lotto createWinningLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public RouletteResult matchWinningNumbers(WinningLotto winningLotto, Lotto lotto) {
        int count = lotto.matchCount(winningLotto.getNumbers());
        boolean isBonusNumber = lotto.isContainNumber(winningLotto.getBonusNumber());
        return RouletteResult.findLottoCompensation(count, isBonusNumber);
    }

    public Lotto getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
