package lotto.domain;

import lotto.dto.WinningResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryMachine {

    public WinningResult judge(List<Lotto> lottos, List<LottoNumber> lottoWinnerNumbers, LottoNumber lottoBonusNumber) {
        Map<Rank, Integer> ranks = new HashMap<>();
        for(Lotto lotto : lottos) {
            int winningCount = lotto.matchWinningNumberCount(lottoWinnerNumbers);
            boolean bonusMatch = lotto.isMatchBonusNumber(lottoBonusNumber);
            mergeNewRank(ranks, Rank.getRating(winningCount, bonusMatch));
        }

        return new WinningResult(ranks);
    }

    private void mergeNewRank(Map<Rank, Integer> ranks, Rank rank) {
        ranks.merge(rank, 1, (k, v) -> ranks.get(rank) + 1);
    }
}
