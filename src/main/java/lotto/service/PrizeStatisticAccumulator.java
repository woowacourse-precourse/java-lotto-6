package lotto.service;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;

public class PrizeStatisticAccumulator {
    public static Map<Prize, Integer> compilePrizeStatistics(Lotto winningLotto, int bonusNumber) {
        Map<Prize, Integer> matchNumberCount = PrizeStatisticStarter.initializePrizeStatistics();

        for (Lotto lottoGame : LottoTicket.lottoGames) {
            LottoResult lottoResult = new LottoResult(lottoGame, winningLotto, bonusNumber);
            LottoResult.updateMatchNumberCount(matchNumberCount, lottoResult);
        }
        return matchNumberCount;
    }
}
