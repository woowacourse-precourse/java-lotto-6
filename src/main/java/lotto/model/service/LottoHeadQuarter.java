package lotto.model.service;

import java.util.List;
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

    public double calculateReturn(Money money, RankingBoard rankingBoard) {
        List<Rank> ranks = rankingBoard.getRanks();
        int lottoProfits = ranks.stream()
                .mapToInt(rank -> rank.getMoney() * rank.getHeadCount())
                .sum();

        return ((double)lottoProfits / money.getMoney()) * 100.0;
    }
}
