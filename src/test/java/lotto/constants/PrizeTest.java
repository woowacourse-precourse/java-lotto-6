package lotto.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

    @DisplayName("당첨 등수 계산, 1등")
    @Test
    void rankFirst() {
        assertThat(Prize.rank(6, false)).isEqualTo(Prize.FIRST);
    }

    @DisplayName("당첨 등수 계산, 2등")
    @Test
    void rankSecond() {
        assertThat(Prize.rank(5, true)).isEqualTo(Prize.SECOND);
    }

    @DisplayName("당첨 등수 계산, 3등")
    @Test
    void rankThird() {
        assertThat(Prize.rank(5, false)).isEqualTo(Prize.THIRD);
    }

    @DisplayName("당첨 등수 계산, 4등")
    @Test
    void rankFourth() {
        assertThat(Prize.rank(4, true)).isEqualTo(Prize.FOURTH);
        assertThat(Prize.rank(4, false)).isEqualTo(Prize.FOURTH);
    }

    @DisplayName("당첨 등수 계산, 5등")
    @Test
    void rankFifth() {
        assertThat(Prize.rank(3, true)).isEqualTo(Prize.FIFTH);
        assertThat(Prize.rank(3, false)).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("당첨되지 않았을 때, null 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 7})
    void rankFifth(int matchingCount) {
        assertThat(Prize.rank(matchingCount, true)).isNull();
        assertThat(Prize.rank(matchingCount, false)).isNull();
    }
}