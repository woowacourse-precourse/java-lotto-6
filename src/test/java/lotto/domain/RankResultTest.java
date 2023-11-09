package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankResultTest {

    @ParameterizedTest
    @CsvSource({
            "FIRST, 1, 2000000000",
            "SECOND, 1, 30000000",
            "THIRD, 1, 1500000",
            "FOURTH, 1, 50000",
            "FIFTH, 1, 5000",
            "NONE, 0, 0"
    })
    @DisplayName("add 메소드는 각 LottoRank의 카운트를 증가시키고, 총 당첨금을 계산한다")
    void testAddAndCalculateTotalWinnings(LottoRank rank, int count, long expectedWinnings) {
        RankResult result = RankResult.create();

        for (int i = 0; i < count; i++) {
            result.add(rank);
        }

        assertEquals(count, result.getCount(rank));

        assertEquals(expectedWinnings, result.calculateTotalWinnings());
    }
}
