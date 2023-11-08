package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @DisplayName("일치하는 번호의 개수와 보너스 번호 일치 여부에 따라 상금을 반환한다.")
    @Test
    void valueOf() {
        assertThat(Prize.valueOf(6, false)).isEqualTo(Prize.FIRST);
        assertThat(Prize.valueOf(5, true)).isEqualTo(Prize.SECOND);
        assertThat(Prize.valueOf(5, false)).isEqualTo(Prize.THIRD);
        assertThat(Prize.valueOf(4, false)).isEqualTo(Prize.FOURTH);
        assertThat(Prize.valueOf(3, false)).isEqualTo(Prize.FIFTH);
        assertThat(Prize.valueOf(2, false)).isEqualTo(Prize.NONE);
    }

    @DisplayName("상금을 반환한다.")
    @Test
    void getPrizeMoney() {
        assertThat(Prize.FIRST.getPrizeMoney()).isEqualTo(2000000000);
        assertThat(Prize.SECOND.getPrizeMoney()).isEqualTo(30000000);
        assertThat(Prize.THIRD.getPrizeMoney()).isEqualTo(1500000);
        assertThat(Prize.FOURTH.getPrizeMoney()).isEqualTo(50000);
        assertThat(Prize.FIFTH.getPrizeMoney()).isEqualTo(5000);
        assertThat(Prize.NONE.getPrizeMoney()).isEqualTo(0);
    }

    @DisplayName("일치하는 번호의 개수를 반환한다.")
    @Test
    void getMatchedNumbers() {
        assertThat(Prize.FIRST.getMatchedNumbers()).isEqualTo(6);
        assertThat(Prize.SECOND.getMatchedNumbers()).isEqualTo(5);
        assertThat(Prize.THIRD.getMatchedNumbers()).isEqualTo(5);
        assertThat(Prize.FOURTH.getMatchedNumbers()).isEqualTo(4);
        assertThat(Prize.FIFTH.getMatchedNumbers()).isEqualTo(3);
        assertThat(Prize.NONE.getMatchedNumbers()).isEqualTo(0);
    }
}
