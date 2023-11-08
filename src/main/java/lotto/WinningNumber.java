package lotto;

import java.util.List;

public class WinningNumber extends Lotto {

    private int bonus = 0;

    public WinningNumber(List<Integer> winningNumber, int bonus) {
        super(winningNumber);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
