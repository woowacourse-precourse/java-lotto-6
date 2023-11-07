package lotto.domain;

import java.util.List;

public class Admin {
    List<Integer> winnerNumber;
    private int bonusNumber;
    List<Integer> Stats;
    public Admin(List<Integer> winnerNumber, int bonusNumber) {
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinnerNumber(){
        return winnerNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
