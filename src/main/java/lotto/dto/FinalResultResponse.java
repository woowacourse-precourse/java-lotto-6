package lotto.dto;

import lotto.domain.prize.constants.PrizeGrade;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.EnumMap;

import static lotto.view.constants.PrintFormat.SEPARATOR_WITH_POINT_FORMAT;

public record FinalResultResponse(
        BigDecimal yield,
        EnumMap<PrizeGrade, Integer> prizeResultCount
) {
    private static final DecimalFormat YIELD_FORMAT = SEPARATOR_WITH_POINT_FORMAT.getFormat();

    public String getFormattedYield() {
        return YIELD_FORMAT.format(yield);
    }
}
