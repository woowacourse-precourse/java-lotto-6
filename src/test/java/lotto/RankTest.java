package lotto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RankTest {
    @DisplayName("6개의 번호가 일치하면 1등인지 알 수 있다.")
    @Test
    public void getRank_First() {
        assertThat(Rank.getRank(6, false))
                .isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개의 번호가 일치하고 보너스 번호가 일치하면 2등인지 알 수 있다.")
    @Test
    public void getRank_Second() {
        assertThat(Rank.getRank(5, true))
                .isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개의 번호가 일치하면 3등인지 알 수 있다.")
    @Test
    public void getRank_Third() {
        assertThat(Rank.getRank(5, false))
                .isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개의 번호가 일치하면 4등인지 알 수 있다.")
    @Test
    public void getRank_Fourth() {
        assertThat(Rank.getRank(4, false))
                .isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개의 번호가 일치하면 5등인지 알 수 있다.")
    @Test
    public void getRank_Fifth() {
        assertThat(Rank.getRank(3, false))
                .isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하의 번호가 일치하면 당첨되지 않은 것을 알 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0})
    public void getRank_Miss(int countOfMatch) {
        assertThat(Rank.getRank(countOfMatch, false))
                .isEqualTo(Rank.MISS);
    }
}
