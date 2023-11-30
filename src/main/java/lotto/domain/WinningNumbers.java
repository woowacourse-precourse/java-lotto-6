package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers of(List<Integer> winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    public int size() {
        return winningNumbers.size();
    }

    public int get(int index) {
        return winningNumbers.get(index);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
