package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DrawResultTest {
    Map<LottoRank, Integer> rankMap = new LinkedHashMap<>();

    @BeforeEach
    void setup() {
        for (LottoRank value : LottoRank.values()) {
            rankMap.put(value, 1);
        }
    }

    @Test
    void 모든등수에_1명씩_당첨된경우의_수익률반환() {
        DrawResult drawResult = new DrawResult(rankMap);
        double earningRate = drawResult.getEarningRate(1000);
        assertThat(earningRate).isEqualTo(203155500);
    }
}