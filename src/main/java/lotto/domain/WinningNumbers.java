package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private List<Integer> winningNumber;

    public WinningNumbers(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        this.winningNumber = lotto.getNumbers();
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
