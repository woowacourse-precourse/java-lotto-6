package lotto.domain.lotto;

import lotto.global.constant.BonusNumberMatch;
import lotto.global.constant.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private Lottos lottos;
    private WinningNumbers winningNumbers;

    public LottoGame(Lottos lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;

    }

    public Map<LottoRank, Integer> calculateLottoResults() {
        Map<LottoRank, Integer> rankMap = new HashMap<>();

        List<Lotto> lottos = this.lottos.getLottos();
        for (Lotto lotto : lottos) {
            int matchNumber = winningNumbers.compareWinningNormalNumberWithLotto(lotto);
            BonusNumberMatch bonusNumberMatch = winningNumbers.compareBonusNumberWithLotto(lotto, matchNumber);

            LottoRank rank = LottoRank.getRank(matchNumber, bonusNumberMatch);
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
