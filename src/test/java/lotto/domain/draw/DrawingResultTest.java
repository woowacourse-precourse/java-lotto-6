package lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import lotto.domain.lotto.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawingResultTest {

    private DrawingResult drawingResult;

    @BeforeEach
    void setUp() {
        EnumMap<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.ranks) {
            result.put(rank, 0);
        }
        result.put(LottoRank.FIFTH, 1);
        result.put(LottoRank.NONE, 7);

        drawingResult = new DrawingResult(result);
    }

    @DisplayName("소수점 첫째자리까지 수익률 계산")
    @Test
    void should_calculate_profit() {
        // when
        double profit = drawingResult.calculateProfitRate();

        // then
        assertThat(profit).isEqualTo(62.5);
    }
}