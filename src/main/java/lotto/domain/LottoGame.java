package lotto.domain;

import java.util.List;

public class LottoGame {
    private final Lotto winningNum;
    private final Integer bonusNum;

    public LottoGame(Lotto winningNum, Integer bonusNum){
        this.winningNum = winningNum;
        this.bonusNum = bonusNum;
    }

    public Lotto getWinningNum(){
        return winningNum;
    }

    public Integer getBonusNum(){
        return bonusNum;
    }
}
