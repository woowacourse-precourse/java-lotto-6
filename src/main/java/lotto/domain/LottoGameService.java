package lotto.domain;

import java.util.*;
import lotto.domain.numbergenerator.NumberGenerator;

public class LottoGameService {
    LottoWinningChecker lottoWinningChecker;
    public Map<LottoRank, Integer> getResultRankCount(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        lottoWinningChecker = new LottoWinningChecker(winningNumber, bonusNumber);
        Map<LottoRank, Integer> rankCount = new LinkedHashMap<>();
        for(LottoRank lottoRank: LottoRank.values()) {
            rankCount.put(lottoRank, 0);
        }
        for(Lotto lotto: lottos) {
            LottoRank rank = lottoWinningChecker.getRank(lotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
        return rankCount;
    }

    public List<Lotto> generateLottos(int money, NumberGenerator generator) {
        // 검증된 금액 입력 받기
        LottoGenerator lottoGenerator = new LottoGenerator(money, generator);
        lottoGenerator.makeLottos();
        return lottoGenerator.getLottos();
    }
}
