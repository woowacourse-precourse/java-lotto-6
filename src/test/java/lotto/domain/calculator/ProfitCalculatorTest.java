package lotto.domain.calculator;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {
    @DisplayName("총 상금을 정확하게 계산한다")
    @Test
    void calculateTotalPrize() {
        List<Rank> ranks = List.of(
                Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.NONE
        );

        ProfitCalculator profitCalculator = new ProfitCalculator();
        int totalPrize = profitCalculator.calculateTotalPrize(ranks);

        assertThat(totalPrize).isEqualTo(
                Rank.FIRST.getPrize() + Rank.SECOND.getPrize() +
                        Rank.THIRD.getPrize() + Rank.FOURTH.getPrize() +
                        Rank.FIFTH.getPrize()
        );
    }

    @DisplayName("총 수익률을 정확하게 계산한다")
    @Test
    void calculateTotalProfitRate() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        int totalPrize = 15000;
        long purchaseAmount = 10000;

        double totalProfitRate = profitCalculator.calculateTotalProfitRate(totalPrize, purchaseAmount);

        assertThat(totalProfitRate).isEqualTo((double) totalPrize / purchaseAmount * 100.0);
    }
}