package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("로또 1등 테스트")
    @Test
    void getRankFirstTest() {
        Rank rank = Rank.getRank(6, false);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("로또 2등 테스트")
    @Test
    void getRankSecondTest() {
        Rank rank = Rank.getRank(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("로또 3등 테스트")
    @Test
    void getRankThirdTest() {
        Rank rank = Rank.getRank(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("로또 4등 테스트")
    @Test
    void getRankFourthTest() {
        Rank rank = Rank.getRank(4, false);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("로또 5등 테스트")
    @Test
    void getRankFifthTest() {
        Rank rank = Rank.getRank(3, false);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또 당첨 실패 테스트")
    @Test
    void getRankLoseTest() {
        Rank rank = Rank.getRank(2, false);

        assertThat(rank).isEqualTo(Rank.LOSE);
    }
}
