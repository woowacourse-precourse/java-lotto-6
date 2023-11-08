package lotto.domain;

import java.util.List;

public class WinningNumber {
    List<Integer> winningNumbers;

    public WinningNumber() {
    }

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }


}
