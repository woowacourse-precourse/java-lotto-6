package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @DisplayName("일치하는 숫자 갯수와 보너스 볼 여부에 따라 Prize를 가져올 수 있다.")
    @Test
    void valueOf_MatchCountAndMatchBonus_ReturnsCorrectPrize() {
        assertThat(Prize.valueOf(3, false)).isEqualTo(Prize.FIFTH);
        assertThat(Prize.valueOf(4, false)).isEqualTo(Prize.FOURTH);
        assertThat(Prize.valueOf(5, false)).isEqualTo(Prize.THIRD);
        assertThat(Prize.valueOf(5, true)).isEqualTo(Prize.SECOND);
        assertThat(Prize.valueOf(6, false)).isEqualTo(Prize.FIRST);
        assertThat(Prize.valueOf(2, false)).isEqualTo(Prize.NONE);
    }

    @DisplayName("Prize의 일치하는 숫자, 상금, 메시지를 가져올 수 있다.")
    @Test
    void getters_ReturnsCorrectValues() {
        assertThat(Prize.FIFTH.getMatchCount()).isEqualTo(3);
        assertThat(Prize.FIFTH.getPrizeAmount()).isEqualTo(5_000);
        assertThat(Prize.FIFTH.getMessage()).isEqualTo("3개 일치 (5,000원) - ");

        assertThat(Prize.FIRST.getMatchCount()).isEqualTo(6);
        assertThat(Prize.FIRST.getPrizeAmount()).isEqualTo(2_000_000_000);
        assertThat(Prize.FIRST.getMessage()).isEqualTo("6개 일치 (2,000,000,000원) - ");
    }

}