package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    private final int MINIMUM_MATCH_COUNT = 3;

    @DisplayName("당첨등수가 3개미만일 경우 RANK에서 NONE을 나타내야한다")
    @Test
    void matchCountUnder3() {
        Assertions.assertThat(Rank.match(MINIMUM_MATCH_COUNT - 1, false))
                .isEqualTo(Rank.NONE);
    }

    @DisplayName("당첨등수가 3등일 경우 RANK에서 3등을 나타내어야한다.")
    @Test
    void matchCountEqualOrGreater3() {
        assertThat(Rank.match(MINIMUM_MATCH_COUNT + 2, false))
                .isEqualTo(Rank.THIRD);
    }

    @DisplayName("당첨등수가 2등일 경우 RANK에서 2등을 나타내어야한다.")
    @Test
    void matchCountIs5AndBonusIsTrue() {
        assertThat(Rank.match(MINIMUM_MATCH_COUNT + 2, true))
                .isEqualTo(Rank.SECOND);
    }
}