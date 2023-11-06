package domain;

import java.util.List;

public class LottoSystem {
    private final List<Integer> winningLotto;
    private final int bonusNumber;


    public LottoSystem(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningLotto(){
        return winningLotto;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
