package lotto.service;

import java.util.Map;
import lotto.domain.lotto.LottoCriteria;
import lotto.domain.lotto.LottoResult;

public class ResultDto {

    private final Map<LottoCriteria, Long> result;
    private final float returnRate;

    private ResultDto(LottoResult lottoResult) {
        this.result = lottoResult.getRankingResult();
        this.returnRate = lottoResult.getReturnRate();
    }

    public static ResultDto from(LottoResult lottoResult) {
        return new ResultDto(lottoResult);
    }

    public final Map<LottoCriteria, Long> getResult() {
        return this.result;
    }

    public final float getReturnRate() {
        return returnRate;
    }
}
