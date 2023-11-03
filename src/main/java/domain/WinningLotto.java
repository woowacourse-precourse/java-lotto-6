package domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumbers;

    public WinningLotto(List<Integer> winningNumbers){
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }
}
