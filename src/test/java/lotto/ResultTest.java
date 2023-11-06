package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @DisplayName("맞힌 개수와 보너스 번호 일치 여부에 맞는 결과를 가진다.")
    @Test
    void MatchingNumbersAndBonus() {
        assertThat(Result.from(6, false)).isEqualTo(Result.FIRST_PRIZE);
        assertThat(Result.from(5, true)).isEqualTo(Result.SECOND_PRIZE);
        assertThat(Result.from(5, false)).isEqualTo(Result.THIRD_PRIZE);
        assertThat(Result.from(4, false)).isEqualTo(Result.FOURTH_PRIZE);
        assertThat(Result.from(3, false)).isEqualTo(Result.FIFTH_PRIZE);
        assertThat(Result.from(2, false)).isEqualTo(Result.NO_PRIZE);
        assertThat(Result.from(1, false)).isEqualTo(Result.NO_PRIZE);
        assertThat(Result.from(0, false)).isEqualTo(Result.NO_PRIZE);
    }
}