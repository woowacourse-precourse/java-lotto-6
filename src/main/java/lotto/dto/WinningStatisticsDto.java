package lotto.dto;

import java.math.BigDecimal;
import java.util.EnumMap;
import lotto.domain.Rank;

public class WinningStatisticsDto {
    private final EnumMap<Rank, Integer> eachRankCounts;
    private final BigDecimal yieldRate;

    public WinningStatisticsDto(EnumMap<Rank, Integer> eachRankCounts, BigDecimal yieldRate) {
        this.eachRankCounts = eachRankCounts;
        this.yieldRate = yieldRate;
    }

    public EnumMap<Rank, Integer> getEachRankCounts() {
        return eachRankCounts;
    }

    public BigDecimal getYieldRate() {
        return yieldRate;
    }
}
