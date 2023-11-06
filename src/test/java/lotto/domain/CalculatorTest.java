package lotto.domain;

import lotto.constants.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class CalculatorTest {



    @DisplayName("상금 총액 계산")
    @Test
    void calculateTotalPrize() {
        List<Rank> rankList = List.of(Rank.FOURTH, Rank.SECOND, Rank.FOURTH, Rank.FIFTH);
        Integer totalPrize = Calculator.calculateTotalPrize(rankList);
        Assertions.assertThat(totalPrize).isEqualTo(30105000);
    }


    @Test
    void calculatePricePrizeRatio() {
        Double pricePrizeRatio = Calculator.calculatePricePrizeRatio(16000, 8000);

        Assertions.assertThat(pricePrizeRatio).isEqualTo(200.0);
    }

    @Test
    void calculateLotteryCount() {
        Integer budget = 12000;
        Integer lotteryCount = Calculator.calculateLotteryCount(budget);

        Assertions.assertThat(lotteryCount).isEqualTo(12);
    }
}