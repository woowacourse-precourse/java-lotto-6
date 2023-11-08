package lotto.Model.Domain;

import java.util.ArrayList;
import java.util.List;

public class WinningData {
    List<Integer> winningNumber;
    int winningBonusNumber;

    public WinningData(){
        this.winningNumber = new ArrayList<>();
        winningBonusNumber = 0;
    }

    public List<Integer> getWinningNumber(){
        return winningNumber;
    }
    public int getWinningBonusNumber(){
        return winningBonusNumber;
    }
    public void setWinningNumber(List<Integer> winningNumber){
        this.winningNumber = winningNumber;
    }
    public void setWinningBonusNumber(int winningBonusNumber){
        this.winningBonusNumber = winningBonusNumber;
    }
}
