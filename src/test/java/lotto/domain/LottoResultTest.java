package lotto.domain;

import lotto.enums.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class LottoResultTest {
    private static final int SCALE = 1;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private static final BigDecimal PRIZE_RATE = BigDecimal.valueOf(62.5);
    private static final Map<Ranking, Integer> RANKING_COUNTS;
    static {
        RANKING_COUNTS = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(key -> RANKING_COUNTS.put(key, 0));
        RANKING_COUNTS.put(Ranking.BLANK, 7);
        RANKING_COUNTS.put(Ranking.FIFTH, 1);
    }
    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult(RANKING_COUNTS);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculatePrizeRate() {
        Money money = mock(Money.class);
        when(money.getAmount()).thenReturn(8_000);

        BigDecimal prizeRate = lottoResult.calculatePrizeRate(money, SCALE, ROUNDING_MODE);

        assertThat(prizeRate).isEqualTo(PRIZE_RATE);
        verify(money, times(1)).getAmount();
    }

    @DisplayName("당첨 결과 반환")
    @Test
    void getRankingCounts() {
        assertThat(lottoResult.getRankingCounts()).isEqualTo(RANKING_COUNTS);
    }
}