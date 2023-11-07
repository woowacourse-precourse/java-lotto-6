package lotto.model.service;

import lotto.model.domain.LottoWinNumber;
import lotto.model.domain.RankingBoard;
import lotto.model.domain.vo.BonusNumber;
import lotto.model.domain.vo.Lottos;
import lotto.model.domain.vo.WinNumber;

public class LottoHeadQuarter {

    public LottoHeadQuarter() {
    }

    public LottoWinNumber pickNumber(WinNumber winNumber, BonusNumber bonusNumber) {
        return LottoWinNumber.from(winNumber, bonusNumber);
    }

    public void drawWinner(LottoWinNumber lottoWinNumber, Lottos playerLottos) {
        RankingBoard rankingBoard = RankingBoard.from(lottoWinNumber);
        rankingBoard.drawWinner(playerLottos);
    }

    public void calculateReturn() {

    }

    public void publishResult() {
        
    }
}
