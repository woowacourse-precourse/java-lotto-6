package lotto.domain;

import lotto.exception.WinnerNumberException;

import java.util.List;

public class WinnerNumber {
    private final List<Integer> input;
    public WinnerNumber(List<Integer> input) {
        validate(input);
        this.input = input;
    }

    private void validate(List<Integer> input) {
        WinnerNumberException winnerNumberException = new WinnerNumberException(input);
    }
}
