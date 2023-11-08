package lotto.domain;

import java.util.List;

public class WinningNumber {

    private List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void addNumber(int number) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException();
        }
        this.winningNumber.add(number);
    }
}
