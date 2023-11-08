package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Result.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @DisplayName("맞힌 개수와 보너스 번호 일치 여부에 맞는 결과를 가진다.")
    @Test
    void MatchingNumbersAndBonus() {
        assertThat(Result.from(6, false)).isEqualTo(FIRST_PRIZE);
        assertThat(Result.from(5, true)).isEqualTo(SECOND_PRIZE);
        assertThat(Result.from(5, false)).isEqualTo(THIRD_PRIZE);
        assertThat(Result.from(4, false)).isEqualTo(FOURTH_PRIZE);
        assertThat(Result.from(3, false)).isEqualTo(FIFTH_PRIZE);
        assertThat(Result.from(2, true)).isEqualTo(NO_PRIZE);
        assertThat(Result.from(1, true)).isEqualTo(NO_PRIZE);
        assertThat(Result.from(0, false)).isEqualTo(NO_PRIZE);
    }

    @DisplayName("결과에 맞는 상금을 반환한다.")
    @Test
    void getPrize() {
        assertEquals(FIRST_PRIZE.getPrize(), 2_000_000_000);
        assertEquals(SECOND_PRIZE.getPrize(), 30_000_000);
        assertEquals(THIRD_PRIZE.getPrize(), 1_500_000);
        assertEquals(FOURTH_PRIZE.getPrize(), 50_000);
        assertEquals(FIFTH_PRIZE.getPrize(), 5_000);
        assertEquals(NO_PRIZE.getPrize(), 0);
    }
}