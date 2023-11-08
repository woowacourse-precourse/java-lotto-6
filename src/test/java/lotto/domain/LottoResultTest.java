package lotto.domain;

import lotto.enums.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class LottoResultTest {
    private static final int SCALE = 1, LOTTOS_SIZE = 8;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private static final BigDecimal PRIZE_RATE = BigDecimal.valueOf(62.5);
    private static final Map<Ranking, Integer> VALID_RANKING_COUNTS;
    static {
        VALID_RANKING_COUNTS = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(key -> VALID_RANKING_COUNTS.put(key, 0));
        VALID_RANKING_COUNTS.put(Ranking.BLANK, 7);
        VALID_RANKING_COUNTS.put(Ranking.FIFTH, 1);
    }
    LottoResult lottoResult;

    @DisplayName("로또 결과 생성")
    @Test
    void createLottoResult_성공() {
        assertThatCode(() -> new LottoResult(VALID_RANKING_COUNTS, LOTTOS_SIZE))
                .doesNotThrowAnyException();
    }

    @DisplayName("Keys가 모든 Ranking을 포함하지 않으면 에러 발생")
    @Test
    void createLottoResult_Keys가유효하지않을때() {
        Map<Ranking, Integer> invalidRankingCounts = new EnumMap<>(Ranking.class);
        invalidRankingCounts.put(Ranking.FIRST, 1);

        assertThatThrownBy(() -> new LottoResult(invalidRankingCounts, LOTTOS_SIZE))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("Values에 음수가 있으면 에러 발생")
    @Test
    void createLottoResult_Values에음수가있을때() {
        Map<Ranking, Integer> invalidRankingCounts = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(key -> invalidRankingCounts.put(key, 0));
        invalidRankingCounts.put(Ranking.FIRST, -1);

        assertThatThrownBy(() -> new LottoResult(invalidRankingCounts, LOTTOS_SIZE))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("Values의 합이 발행한 로또 수보다 많으면 예외 발생")
    @Test
    void createLottoResult_Values의값이유효하지않을때() {
        lottoResult = new LottoResult(VALID_RANKING_COUNTS, LOTTOS_SIZE);
        Map<Ranking, Integer> invalidRankingCounts = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(key -> invalidRankingCounts.put(key, 0));
        invalidRankingCounts.put(Ranking.FIRST, 100);

        assertThatThrownBy(() -> new LottoResult(invalidRankingCounts, LOTTOS_SIZE))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculatePrizeRate() {
        lottoResult = new LottoResult(VALID_RANKING_COUNTS, LOTTOS_SIZE);
        Money money = mock(Money.class);
        when(money.getAmount()).thenReturn(8_000);

        BigDecimal prizeRate = lottoResult.calculatePrizeRate(money, SCALE, ROUNDING_MODE);

        assertThat(prizeRate).isEqualTo(PRIZE_RATE);
        verify(money, times(1)).getAmount();
    }

    @DisplayName("당첨 결과 반환")
    @Test
    void getRankingCounts() {
        lottoResult = new LottoResult(VALID_RANKING_COUNTS, LOTTOS_SIZE);
        assertThat(lottoResult.getRankingCounts()).isEqualTo(VALID_RANKING_COUNTS);
    }
}