package lotto.dto;

import lotto.domain.prize.constants.PrizeGrade;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.EnumMap;

public record FinalResultResponse(
        BigDecimal yield,
        EnumMap<PrizeGrade, Integer> prizeResultCount
) {
    private static final DecimalFormat YIELD_FORMAT = new DecimalFormat("#,##0.0");

    public String getFormattedYield() {
        return YIELD_FORMAT.format(yield);
    }
}
