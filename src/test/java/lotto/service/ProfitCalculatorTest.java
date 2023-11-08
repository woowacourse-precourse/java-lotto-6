package lotto.service;

import lotto.service.ProfitCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {
    private final ProfitCalculator profitCalculator = new ProfitCalculator();
    @DisplayName("3개 수익률 계산 확인")
    @Test
    void createThreeMatchesProfit() {
        int budget = 1000;
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",1,
                "matchesFour",0,
                "matchesFive",0,
                "matchesFiveAndBonus",0,
                "matchesSix",0
        );
        assertThat(profitCalculator.calculateProfit(budget,statisticsMatchesCounts))
                .isEqualTo(500.0f);
    }

    @DisplayName("4개 수익률 계산 확인")
    @Test
    void createFourMatchesProfit() {
        int budget = 1000;
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",0,
                "matchesFour",1,
                "matchesFive",0,
                "matchesFiveAndBonus",0,
                "matchesSix",0
        );
        assertThat(profitCalculator.calculateProfit(budget,statisticsMatchesCounts))
                .isEqualTo(5000.0f);
    }

    @DisplayName("5개 수익률 계산 확인")
    @Test
    void createFiveMatchesProfit() {
        int budget = 1000;
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",0,
                "matchesFour",0,
                "matchesFive",1,
                "matchesFiveAndBonus",0,
                "matchesSix",0
        );
        assertThat(profitCalculator.calculateProfit(budget,statisticsMatchesCounts))
                .isEqualTo(150000.0f);
    }

    @DisplayName("5개+보너스번호 수익률 계산 확인")
    @Test
    void createFiveAndBonusMatchesProfit() {
        int budget = 1000;
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",0,
                "matchesFour",0,
                "matchesFive",0,
                "matchesFiveAndBonus",1,
                "matchesSix",0
        );
        assertThat(profitCalculator.calculateProfit(budget,statisticsMatchesCounts))
                .isEqualTo(3000000.0f);
    }

    @DisplayName("6개 수익률 계산 확인")
    @Test
    void createSixMatchesProfit() {
        int budget = 1000;
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",0,
                "matchesFour",0,
                "matchesFive",0,
                "matchesFiveAndBonus",0,
                "matchesSix",1
        );
        assertThat(profitCalculator.calculateProfit(budget,statisticsMatchesCounts))
                .isEqualTo(200000000.0f);
    }
}