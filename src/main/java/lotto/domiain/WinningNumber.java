package lotto.domiain;

import java.util.List;

public class WinningNumber {
    private final Lotto winningLotto;
    private final int bonusBall;

    public WinningNumber(List<Integer> winningLotto, int bonusBall) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusBall = bonusBall;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public boolean isContain(int number){
        return winningLotto.isContain(number);
    }
}
