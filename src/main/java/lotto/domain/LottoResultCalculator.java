package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
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
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            int matchingCount = lotto.countMatchingNumbers(winningNumbers.getNumbers());
            boolean matchingBonus = lotto.containsNumber(bonusNumber.getBonusNumber());
            LottoRankInfo lottoRankInfo = LottoRankInfo.geLottoRankInfo(matchingCount, matchingBonus);

            int currentCount = lottoResult.get(lottoRankInfo);
            lottoResult.replace(lottoRankInfo, currentCount + ONE_COUNT_INCREASE);
        }

        return Collections.unmodifiableMap(lottoResult);
    }

    public long calculateTotalPrizeMoney() {
        return lottoResult.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }
}
