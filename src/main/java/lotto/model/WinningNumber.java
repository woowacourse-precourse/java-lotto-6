package lotto.model;

import java.util.List;

public class WinningNumber {
    private Lotto winningNumber;

    private int bonusNumber;



    public WinningNumber(Lotto winningNumber,int bonusNumber){
        this.winningNumber=winningNumber;
        this.bonusNumber=bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
