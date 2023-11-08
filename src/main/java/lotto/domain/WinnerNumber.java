package lotto.domain;

import lotto.exception.WinnerNumberException;

import java.util.List;

public class WinnerNumber {
    private final List<Integer> winnerNum;

    public WinnerNumber(List<Integer> winnerNum) {
        validate(winnerNum);
        this.winnerNum = winnerNum;
    }

    private void validate(List<Integer> input) {
        new WinnerNumberException(input);
    }

    public List<Integer> getWinnerNumber() {
        return this.winnerNum;
    }
}
