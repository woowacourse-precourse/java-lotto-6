package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Map.Entry;
import lotto.service.PurchaseService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {
    @Test
    @DisplayName("결과에 따른 수익 퍼센테이지를 정확하게 나타낸다.")
    public void calculateProfitAsPercentage(){
        // given
        ProfitCalculator profitCalculator = new ProfitCalculator();
        Map<Rank, Integer> result = Map.ofEntries(
                Map.entry(Rank.FOURTH, 3),
                Map.entry(Rank.THIRD, 1),
                Map.entry(Rank.NONE, 16),
                Map.entry(Rank.FIFTH, 7)
        );
        // when
        double actualPercentage = profitCalculator.calculateProfitRateInPercentage(result);
        // then
        assertThat(actualPercentage).isEqualByComparingTo(
                (double) (Rank.FOURTH.calculateTotalPrizeMoney(3) +
                        Rank.THIRD.calculateTotalPrizeMoney(1) +
                        Rank.FIFTH.calculateTotalPrizeMoney(7)) / (result.size() * PurchaseService.LOTTO_PRICE) * 100
        );
    }
}