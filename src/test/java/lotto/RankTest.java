package lotto;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("일치하는 번호의 개수와 보너스 번호의 일치 여부에 따른 등수를 반환한다.")
    @Test
    void valueOf() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("일치하는 번호의 개수가 3미만일 때는 null을 반환한다.")
    @Test
    void valueOfWhenMatchCountIsLessThanThree() {
        assertThat(Rank.valueOf(2, false)).isNull();
    }

    @DisplayName("등수에 해당하는 상금을 반환한다.")
    @Test
    void getWinningMoney() {
        assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getWinningMoney()).isEqualTo(30_000_000);
        assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(1_500_000);
        assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(50_000);
        assertThat(Rank.FIFTH.getWinningMoney()).isEqualTo(5_000);
    }
}

