package lotto.model;

import java.util.Map;
import java.util.Objects;
import lotto.constant.LottoRanking;
import lotto.dto.WinningStatistics;

public class LottoResult {
    private final Map<LottoRanking, Integer> lottoResults;

    private LottoResult(Map<LottoRanking, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResult from(Map<LottoRanking, Integer> lottoResults) {
        return new LottoResult(lottoResults);
    }

    public void addLottoResult(LottoRanking lottoRanking) {
        if (Objects.nonNull(lottoRanking)) {
            lottoResults.put(lottoRanking, lottoResults.get(lottoRanking) + 1);
        }
    }

    public long calculatePrizeSum() {
        return lottoResults.keySet().stream()
                .map(lottoRanking -> lottoRanking.getPrize() * lottoResults.get(lottoRanking))
                .mapToLong(Long::longValue)
                .sum();
    }

    public WinningStatistics getWinnerStatistics() {
        return new WinningStatistics(lottoResults);
    }
}
