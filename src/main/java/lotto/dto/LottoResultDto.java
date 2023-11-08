package lotto.dto;

import java.util.EnumMap;
import lotto.domain.LottoPrize;

public class LottoResultDto {
    private final double profitRatio;
    private final EnumMap<LottoPrize, Integer> prizeCount;

    public LottoResultDto(EnumMap<LottoPrize, Integer> prizeCount,double profitRatio) {
        this.prizeCount = prizeCount;
        this.profitRatio = profitRatio;
    }
    public double getProfitRatio() {
        return profitRatio;
    }

    public EnumMap<LottoPrize, Integer> getPrizeCount() {
        return prizeCount;
    }

}
