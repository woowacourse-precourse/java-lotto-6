package lotto.domain.analysis;

import java.util.Collections;
import java.util.List;
import lotto.domain.rank.Rank;
import lotto.dto.AnalysisDto;

public class Analysis {

    private final List<Rank> ranks;
    private final double profitRate;

    public Analysis(final List<Rank> ranks, final int count) {
        this.ranks = ranks;
        this.profitRate = calculateProfitRate(ranks, count);
    }

    private double calculateProfitRate(final List<Rank> ranks, final int count) {
        long profit = ranks.stream()
                .mapToLong(Rank::getProfit)
                .sum();
        return (double) profit / count;
    }

    public AnalysisDto toDto() {
        return new AnalysisDto(
                Collections.frequency(this.ranks, Rank.THREE_MATCHED),
                Collections.frequency(this.ranks, Rank.FOUR_MATCHED),
                Collections.frequency(this.ranks, Rank.FIVE_MATCHED),
                Collections.frequency(this.ranks, Rank.FIVE_MATCHED_WITH_BONUS),
                Collections.frequency(this.ranks, Rank.SIX_MATCHED),
                this.profitRate
        );
    }

    public List<Rank> getRanks() {
        return this.ranks;
    }

    public double getProfitRate() {
        return this.profitRate;
    }
}
