package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = applyLottoRules(winningNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    private List<Integer> applyLottoRules(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        return lotto.getNumbers();
    }
}
