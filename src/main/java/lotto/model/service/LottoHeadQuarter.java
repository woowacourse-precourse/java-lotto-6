package lotto.model.service;

import java.util.Map;
import lotto.model.domain.LottoWinNumber;
import lotto.model.domain.RankingBoard;
import lotto.model.domain.vo.BonusNumber;
import lotto.model.domain.vo.Lottos;
import lotto.model.domain.vo.Money;
import lotto.model.domain.vo.Rank;
import lotto.model.domain.vo.WinNumber;

public class LottoHeadQuarter {

    public LottoHeadQuarter() {
    }

    public LottoWinNumber pickNumber(WinNumber winNumber, BonusNumber bonusNumber) {
        return LottoWinNumber.from(winNumber, bonusNumber);
    }

    public RankingBoard drawWinner(LottoWinNumber lottoWinNumber, Lottos playerLottos) {
        RankingBoard rankingBoard = RankingBoard.from(lottoWinNumber);
        rankingBoard.drawWinner(playerLottos);
        return rankingBoard;
    }

    public double calculateYield(Money money, RankingBoard rankingBoard) {
        Map<Rank, Integer> rankCount = rankingBoard.getRankCount();
        long lottoProfits = 0;
        for (Rank rank : Rank.values()) {
            lottoProfits += (rank.getMoney() * rankCount.get(rank));
        }
        return ((double)lottoProfits / money.getMoney()) * 100.0;
    }
}
