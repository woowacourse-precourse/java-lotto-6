package lotto.controller;

import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.view.message.exception.BudgetInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ProfitCalculatorTest {
    private final ProfitCalculator profitCalculator = new ProfitCalculator();
    @DisplayName("수익률 계산 확인")
    @Test
    void profitTest1() {
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

    @DisplayName("수익률 계산 확인")
    @Test
    void profitTest2() {
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

    @DisplayName("수익률 계산 확인")
    @Test
    void profitTest3() {
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

    @DisplayName("수익률 계산 확인")
    @Test
    void profitTest4() {
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

    @DisplayName("수익률 계산 확인")
    @Test
    void profitTest5() {
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