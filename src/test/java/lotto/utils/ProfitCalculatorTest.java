package lotto.utils;

import lotto.model.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ProfitCalculatorTest {

    @Test
    @DisplayName("수익률 계산이 정확해야 한다")
    void testCalculateProfitRate() {
        int purchaseAmount = 14000;

        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        results.put(LottoRank.NONE, 10);
        results.put(LottoRank.FIFTH, 0);
        results.put(LottoRank.FOURTH, 1);
        results.put(LottoRank.THIRD, 2);
        results.put(LottoRank.SECOND, 0);
        results.put(LottoRank.FIRST, 0);

        double profitRate = ProfitCalculator.calculateProfitRate(results, purchaseAmount);

        double expectedTotalPrize = (1_500_000 * 2) + (50_000 * 1);
        double expectedProfitRate = (expectedTotalPrize / purchaseAmount) * 100;

        assertThat(profitRate).isEqualTo(expectedProfitRate, within(0.1));
    }

    @Test
    @DisplayName("수익률이 소수점 둘째 자리에서 반올림되어야 한다")
    void testProfitRateRoundedToFirstDecimalPlace() {
        int purchaseAmount = 3500;
        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        results.put(LottoRank.FIFTH, 1);

        double profitRate = ProfitCalculator.calculateProfitRate(results, purchaseAmount);
        double expectedProfitRate = 142.9;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    @Test
    @DisplayName("구매 금액보다 당첨 금액이 많을 경우 수익률이 100% 이상이어야 한다")
    void testProfitRateAboveHundredPercent() {
        int purchaseAmount = 3000;

        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        results.put(LottoRank.FOURTH, 1);

        double profitRate = ProfitCalculator.calculateProfitRate(results, purchaseAmount);

        assertThat(profitRate).isGreaterThan(100.0);
    }

    @Test
    @DisplayName("구매 금액과 당첨 금액이 동일할 경우 수익률이 100% 이어야 한다")
    void testProfitRateAtHundredPercent() {
        int purchaseAmount = 50000;

        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        results.put(LottoRank.FOURTH, 1);

        double profitRate = ProfitCalculator.calculateProfitRate(results, purchaseAmount);

        assertThat(profitRate).isEqualTo(100.0);
    }

    @Test
    @DisplayName("구매 금액보다 당첨 금액이 적을 경우 수익률이 100% 미만이어야 한다")
    void testProfitRateBelowHundredPercent() {
        int purchaseAmount = 200000;

        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        results.put(LottoRank.FIFTH, 4);

        double profitRate = ProfitCalculator.calculateProfitRate(results, purchaseAmount);

        assertThat(profitRate).isLessThan(100.0);
    }

    @Test
    @DisplayName("당첨이 전혀 없을 경우 수익률이 0% 이어야 한다")
    void testProfitRateAtZeroPercent() {
        int purchaseAmount = 100000;

        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        results.put(LottoRank.NONE, 50);

        double profitRate = ProfitCalculator.calculateProfitRate(results, purchaseAmount);

        assertThat(profitRate).isEqualTo(0.0);
    }
}