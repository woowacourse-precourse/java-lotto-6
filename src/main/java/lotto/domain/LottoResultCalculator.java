package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResultCalculator {

    private final Map<LottoRankInfo, Integer> lottoResult;

    public LottoResultCalculator() {
        lottoResult = new HashMap<>();
        initializeResult();
    }

    private void initializeResult() {
        for (LottoRankInfo lottoRankInfo : LottoRankInfo.values()) {
            lottoResult.put(lottoRankInfo, 0);
        }
    }

    public Map<LottoRankInfo, Integer> generateLottoResult(LottoTickets lottoTickets,
                                                           LottoWinningNumbers winningNumbers, LottoBonusNumber bonusNumber) {
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            int matchingCount = lotto.countMatchingNumbers(winningNumbers.getNumbers());
            boolean matchingBonus = lotto.containsNumber(bonusNumber.getBonusNumber());
            LottoRankInfo lottoRankInfo = LottoRankInfo.geLottoRankInfo(matchingCount, matchingBonus);

            int currentCount = lottoResult.get(lottoRankInfo);
            lottoResult.replace(lottoRankInfo, currentCount + 1);
        }

        return Collections.unmodifiableMap(lottoResult);
    }

    public Map<LottoRankInfo, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
