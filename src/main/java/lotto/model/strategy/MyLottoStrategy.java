package lotto.model.strategy;

import java.util.EnumMap;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.RankCount;
import lotto.model.lotto.WinningLotto;
import lotto.model.lotto.LottoRank;

public class MyLottoStrategy implements LottoStrategy {
    @Override
    public RankCount determineRankCounts(LottoTicket lottoTicket, WinningLotto winningLotto, BonusNumber bonusNumber) {
        RankCount rankCounts = new RankCount();

        lottoTicket.getLottoTicket()
                .forEach(lotto -> {
                    LottoRank rank = determineLottoRank(lotto, winningLotto, bonusNumber);
                    rankCounts.incrementCount(rank);
                });

        return rankCounts;
    }

    @Override
    public LottoRank determineLottoRank(Lotto lotto, WinningLotto winningLotto, BonusNumber bonusNumber) {
        int matchCount = getmatchingNumbers(lotto, winningLotto);
        boolean matchBonus = hasBonusNumber(lotto, bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    private int getmatchingNumbers(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.getLotto().stream().filter(winningLotto.getLotto()::contains).count();
    }

    private boolean hasBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getLotto().contains(bonusNumber.getValue());
    }

}
