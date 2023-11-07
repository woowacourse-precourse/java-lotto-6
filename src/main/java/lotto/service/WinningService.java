package lotto.service;

import lotto.domain.*;

public class WinningService {

    public WinningScores calWinningScores(Lottos lottos, WinningManager winningManager){
        return lottos.calWinningScores(winningManager);
    }

    public String getWinningScoresResult(WinningScores winningScores){
        return winningScores.toString();
    }

}
