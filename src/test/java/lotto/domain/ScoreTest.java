package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreTest {
    private Map<LottoRank, Integer> lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new HashMap<>();
    }

    @Test
    void testGetProfitRate() {
        // given
        lottoResult.put(LottoRank.FIFTH_PRIZE, 1);
        lottoResult.put(LottoRank.NO_PRIZE, 7);
        double expectedProfitRate = 62.5;

        // when
        Score score = new Score(lottoResult);

        // then
        assertEquals(expectedProfitRate, score.getProfitRate(), 0.01);
    }

}