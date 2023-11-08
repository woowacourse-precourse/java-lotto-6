package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProfitRateTest {
    @Test
    @DisplayName("1등 수익률")
    void calculateFirstRankProfitRateTest() {
        Map<Rank, Integer> matchRankCount = new HashMap<>();
        matchRankCount.putAll(Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0
        ));
        int purchaseAmount = 4000;

        ProfitRate profitRate = new ProfitRate(matchRankCount, purchaseAmount);
        double actualProfitRate = profitRate.getProfitRate();

        double expectedProfitRate = 50000000.0;
        assertEquals(expectedProfitRate, actualProfitRate);
    }

    @Test
    @DisplayName("2등 수익률")
    void calculateSecondRankProfitRateTest() {
        Map<Rank, Integer> matchRankCount = new HashMap<>();
        matchRankCount.putAll(Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 1,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0
        ));
        int purchaseAmount = 7000;

        ProfitRate profitRate = new ProfitRate(matchRankCount, purchaseAmount);
        double actualProfitRate = profitRate.getProfitRate();

        double expectedProfitRate = 428571.4;
        assertEquals(expectedProfitRate, actualProfitRate);
    }

    @Test
    @DisplayName("3등 수익률")
    void calculateThirdRankProfitRateTest() {
        Map<Rank, Integer> matchRankCount = new HashMap<>();
        matchRankCount.putAll(Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 1,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0
        ));
        int purchaseAmount = 6000;

        ProfitRate profitRate = new ProfitRate(matchRankCount, purchaseAmount);
        double actualProfitRate = profitRate.getProfitRate();

        double expectedProfitRate = 25000.0;
        assertEquals(expectedProfitRate, actualProfitRate);
    }

    @Test
    @DisplayName("4등 수익률")
    void calculateFourthRankProfitRateTest() {
        Map<Rank, Integer> matchRankCount = new HashMap<>();
        matchRankCount.putAll(Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 1,
                Rank.FIFTH, 0
        ));
        int purchaseAmount = 3000;

        ProfitRate profitRate = new ProfitRate(matchRankCount, purchaseAmount);
        double actualProfitRate = profitRate.getProfitRate();

        double expectedProfitRate = 1666.7;
        assertEquals(expectedProfitRate, actualProfitRate);
    }

    @Test
    @DisplayName("5등 수익률")
    void calculateFifthRankProfitRateTest() {
        Map<Rank, Integer> matchRankCount = new HashMap<>();
        matchRankCount.putAll(Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 1
        ));
        int purchaseAmount = 17000;

        ProfitRate profitRate = new ProfitRate(matchRankCount, purchaseAmount);
        double actualProfitRate = profitRate.getProfitRate();

        double expectedProfitRate = 29.4;
        assertEquals(expectedProfitRate, actualProfitRate);
    }
}