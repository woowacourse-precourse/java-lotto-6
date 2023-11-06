package lotto.dto;

import lotto.constant.LottoRank;
import java.util.Map;

public record LottoResultDto(double profitRate, Map<LottoRank, Integer> result) {
    public LottoResultDto(double profitRate, Map<LottoRank, Integer> result) {
        this.profitRate = profitRate;
        result.remove(LottoRank.OUT_RANK);
        this.result = result;
    }
}
