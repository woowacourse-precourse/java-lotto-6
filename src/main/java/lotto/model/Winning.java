package lotto.model;

import java.util.List;

public class Winning {
    private final List<Integer> winningNumber;

    public Winning(List<Integer> winningNumber){
        this.winningNumber = winningNumber;
    }

    public List<Integer> getWinning() {
        return winningNumber;
    }
}
