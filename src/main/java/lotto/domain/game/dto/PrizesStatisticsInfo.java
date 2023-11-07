package lotto.domain.game.dto;

import java.math.BigDecimal;
import java.util.List;

public record PrizesStatisticsInfo(
        List<Integer> prizeCounts,
        BigDecimal profitRate
) {
    public PrizesStatisticsInfo(final List<Integer> prizeCounts, final BigDecimal profitRate) {
        this.prizeCounts = prizeCounts;
        this.profitRate = profitRate;
    }


}
