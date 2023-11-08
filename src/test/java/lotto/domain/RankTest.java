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

    @Test
    void getPrize() {
    }

    @Test
    void getMessage() {
    }

    @Test
    void values() {
    }

}