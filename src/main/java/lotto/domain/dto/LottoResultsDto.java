package lotto.domain.dto;

import java.util.Collections;
import java.util.Map;
import lotto.domain.lottoresult.LottoPrizeMoney;
import lotto.domain.lottoresult.LottoResult;

public class LottoResultsDto {
    private final Map<LottoResult, Integer> lottoResultsData;
    private final LottoPrizeMoney lottoPrizeMoney;

    public LottoResultsDto(Map<LottoResult, Integer> lottoResultsData, LottoPrizeMoney lottoPrizeMoney) {
        this.lottoResultsData = lottoResultsData;
        this.lottoPrizeMoney = lottoPrizeMoney;
    }

    public Map<LottoResult, Integer> getLottoResultsData() {
        return Collections.unmodifiableMap(lottoResultsData);
    }

    public long getTotalLottoPrizeMoney() {
        return lottoPrizeMoney.getLottoPrizeMoney();
    }
}
