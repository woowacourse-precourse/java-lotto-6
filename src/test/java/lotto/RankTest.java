package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    @DisplayName("1등 생성 테스트")
    void createFirstRank() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등 생성 테스트")
    void createSecondRank() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등 생성 테스트")
    void createThirdRank() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4등 생성 테스트")
    void createFourthRank() {
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("5등 생성 테스트")
    void createFifthRank() {
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("미당첨 테스트(2개 이하로 맞았을 경우)")
    void createNoneRank() {
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.NONE);
    }
}
