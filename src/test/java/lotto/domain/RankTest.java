package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("당첨 순위를 판단한다.")
    @Test
    void getRank() {
        Rank actual = Rank.getRank(3, true);
        Assertions.assertThat(actual).isEqualTo(Rank.FIFTH);

        actual = Rank.getRank(4, true);
        Assertions.assertThat(actual).isEqualTo(Rank.FOURTH);

        actual = Rank.getRank(5, false);
        Assertions.assertThat(actual).isEqualTo(Rank.THIRD);

        actual = Rank.getRank(5, true);
        Assertions.assertThat(actual).isEqualTo(Rank.SECOND);

        actual = Rank.getRank(6, false);
        Assertions.assertThat(actual).isEqualTo(Rank.FIRST);
    }

    @DisplayName("당첨 순위의 상금을 가져온다.")
    @Test
    void getPrize() {
        Assertions.assertThat(5_000).isEqualTo(Rank.FIFTH.getPrize());
        Assertions.assertThat(50_000).isEqualTo(Rank.FOURTH.getPrize());
        Assertions.assertThat(1_500_000).isEqualTo(Rank.THIRD.getPrize());
        Assertions.assertThat(30_000_000).isEqualTo(Rank.SECOND.getPrize());
        Assertions.assertThat(2_000_000_000).isEqualTo(Rank.FIRST.getPrize());
    }

    @Test
    void getMessage() {
    }

    @Test
    void values() {
    }

}