package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultsTest {
    private LottoResults lottoResults;

    @BeforeEach
    void setUp() {
        lottoResults = new LottoResults();
    }
    @Test
    @DisplayName("당첨 결과 추가 테스트")
    public void testAddResult() {
        // GIVEN
        LottoRank rankToAdd = LottoRank.FIRST;
        int expectedCount = 1;

        // WHEN
        lottoResults.addResult(rankToAdd);

        // THEN
        assertEquals(expectedCount, lottoResults.getResults().get(rankToAdd));
    }
    @Test
    @DisplayName("총 당첨금 계산 테스트")
    public void testCalculateTotalPrize() {
        // GIVEN
        lottoResults.addResult(LottoRank.FIRST);
        lottoResults.addResult(LottoRank.SECOND);
        int expectedTotalPrize = LottoRank.FIRST.getReward() + LottoRank.SECOND.getReward();

        // WHEN
        double totalPrize = lottoResults.calculateTotalPrize();

        // THEN
        assertEquals(expectedTotalPrize, totalPrize);
    }
}
