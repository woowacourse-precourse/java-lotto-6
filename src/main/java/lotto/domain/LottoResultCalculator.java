package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    private static final int DEFAULT_WINNING_COUNT = 0;
    private static final int ONE_COUNT_INCREASE = 1;

    private final Map<LottoRankInfo, Integer> lottoResult;

    public LottoResultCalculator() {
        lottoResult = new HashMap<>();
        initializeResult();
    }

    private void initializeResult() {
        for (LottoRankInfo lottoRankInfo : LottoRankInfo.values()) {
            lottoResult.put(lottoRankInfo, DEFAULT_WINNING_COUNT);
        }
    }

    public Map<LottoRankInfo, Integer> generateLottoResult(LottoTickets lottoTickets,
                                                           LottoWinningNumbers winningNumbers, LottoBonusNumber bonusNumber) {
        List<LottoRankInfo> rankInfos = lottoTickets.createLottoRankInfos(winningNumbers, bonusNumber);
        for (LottoRankInfo rankInfo : rankInfos) {
            int currentCount = lottoResult.get(rankInfo);
            lottoResult.replace(rankInfo, currentCount + ONE_COUNT_INCREASE);
        }

        return Collections.unmodifiableMap(lottoResult);
    }

    public long calculateTotalPrizeMoney() {
        return lottoResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().calculateTotalPrize(entry.getValue()))
                .sum();
    }
}
