package lotto.dto;

import lotto.domain.rank;
import java.util.Map;

public record LottoResultDto(double profitRate, Map<rank, Integer> result) {
    public LottoResultDto(double profitRate, Map<rank, Integer> result) {
        this.profitRate = profitRate;
        result.remove(rank.OUT_RANK);
        this.result = result;
    }
}
