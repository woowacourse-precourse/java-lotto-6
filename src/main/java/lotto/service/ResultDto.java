package lotto.service;

import java.util.Map;
import lotto.domain.lotto.LottoCriteria;
import lotto.domain.lotto.LottoResult;

public class ResultDto {

    private final Map<LottoCriteria, Long> result;
    private final float returnRate;
    
    public ResultDto(LottoResult lottoResult) {
        this.result = lottoResult.getRankingResult();
        this.returnRate = lottoResult.getReturnRate();
    }

    public final Map<LottoCriteria, Long> getResult() {
        return this.result;
    }

    public final float getReturnRate() {
        return returnRate;
    }
}
