package lotto.dto;

import lotto.domain.prize.FinalResults;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static lotto.view.constants.PrintFormat.SEPARATOR_WITH_POINT_FORMAT;

public record FinalResultResponse(
        BigDecimal yield,
        FinalResults finalResults
) {
    private static final DecimalFormat YIELD_FORMAT = SEPARATOR_WITH_POINT_FORMAT.getFormat();

    public String getFormattedYield() {
        return YIELD_FORMAT.format(yield);
    }
}
