package lotto.domain.game;

import lotto.domain.lotto.*;
import lotto.global.constant.BonusNumberMatch;
import lotto.global.constant.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private Lottos lottos;

    private WinningNumbers winningNumbers;


    public LottoGame() {
    }

    public Map<LottoRank, Integer> calculateLottoResults(Lottos lottos, WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> rankMap = new HashMap<>();

        List<Lotto> lottoList = lottos.getLottos();
        for (Lotto lotto : lottoList) {

            int matchCnt = winningNumbers.getWinningNumberMatchCount(lotto);
            BonusNumberMatch bonusNumberMatch = winningNumbers.isBonusNumberMatch(lotto, matchCnt);

            LottoRank rank = LottoRank.getRank(matchCnt, bonusNumberMatch);
            calculateRankMap(rankMap, rank);
        }
        return rankMap;
    }

    private void calculateRankMap(Map<LottoRank, Integer> rankMap, LottoRank rank) {
        int rankCount = rankMap.getOrDefault(rank, 0);
        rankCount += 1;
        rankMap.put(rank, rankCount);
    }


}
