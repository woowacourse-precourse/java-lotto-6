package lotto.service;

import java.util.Map;
import lotto.domain.LottoCriteria;
import lotto.domain.LottoResult;

public class ResultDto {

    private final Map<LottoCriteria, Long> result;
    private final float returnRate;

    public ResultDto(LottoResult lottoResult) {
        this.result = lottoResult.getRankingResult();
        this.returnRate = lottoResult.getReturnRate();
    }

    public Map<LottoCriteria, Long> getResult() {
        return this.result;
    }

    public float getReturnRate() {
        return returnRate;
    }
}
