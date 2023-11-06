package lotto.dto;

import lotto.domain.prize.constants.PrizeGrade;

import java.math.BigDecimal;
import java.util.EnumMap;

public record FinalResultResponse(
        BigDecimal yield,
        EnumMap<PrizeGrade, Integer> prizeResultCount
) {
    public String convertYieldToString() {
        return yield.toPlainString();
    }
}
