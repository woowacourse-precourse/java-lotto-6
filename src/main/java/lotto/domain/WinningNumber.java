package lotto.domain;

import java.util.List;

public class WinningNumber {
    
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int calculateCorrectNumberCount(Lotto lotto) {
        int count = 0;
        for (int number : winningNumber) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
