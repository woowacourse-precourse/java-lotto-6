package lotto.model;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public long compareWinningNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().filter(winningNumbers::contains).count();
    }
}
