package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("일치하는 등수를 올바르게 가져오는지 테스트")
    void valueOf() {
        Rank firstRank = Rank.valueOf(6, false);
        Rank secondRankWithBonus = Rank.valueOf(5, true);
        Rank thirdRank = Rank.valueOf(5, false);
        Rank fourthRank = Rank.valueOf(4, false);
        Rank fifthRank = Rank.valueOf(3, false);
        Rank noneRank = Rank.valueOf(0, false);

        assertEquals(Rank.FIRST, firstRank);
        assertEquals(Rank.SECOND, secondRankWithBonus);
        assertEquals(Rank.THIRD, thirdRank);
        assertEquals(Rank.FOURTH, fourthRank);
        assertEquals(Rank.FIFTH, fifthRank);
        assertEquals(Rank.NONE, noneRank);
    }

    @Test
    @DisplayName("등수별 상금을 올바르게 계산하는지 테스트")
    void calculateTotalPrize() {
        Map<Rank, Integer> resultCount = new HashMap<>();
        resultCount.put(Rank.FIRST, 1);
        resultCount.put(Rank.SECOND, 2);
        resultCount.put(Rank.THIRD, 3);
        resultCount.put(Rank.FOURTH, 4);
        resultCount.put(Rank.FIFTH, 5);
        resultCount.put(Rank.NONE, 6);

        int totalPrize = Rank.calculateTotalPrize(resultCount);
        int expectedTotalPrize = 1 * Rank.FIRST.getPrize() +
                2 * Rank.SECOND.getPrize() +
                3 * Rank.THIRD.getPrize() +
                4 * Rank.FOURTH.getPrize() +
                5 * Rank.FIFTH.getPrize();

        assertEquals(expectedTotalPrize, totalPrize);
    }
}
