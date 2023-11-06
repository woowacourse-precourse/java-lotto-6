package lotto.dto;

import lotto.domain.Rank;
import java.util.Map;

public record LottoResultDto(double profitRate, Map<Rank, Integer> result) {
    public LottoResultDto(double profitRate, Map<Rank, Integer> result) {
        this.profitRate = profitRate;
        result.remove(Rank.OUT_RANK);
        this.result = result;
    }
}
