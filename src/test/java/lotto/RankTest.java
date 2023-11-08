package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    private final int MINIMUM_MATCH_COUNT = 3;

    @DisplayName("당첨 개수가 3개 미만일 경우")
    @Test
    void matchCountUnder3() {
        Assertions.assertThat(Rank.match(MINIMUM_MATCH_COUNT - 1, false))
                .isEqualTo(Rank.FAIL);
    }

    @DisplayName("당첨 개수가 3개 이상일 경우")
    @Test
    void matchCountEqualOrGreater3() {
        assertThat(Rank.match(MINIMUM_MATCH_COUNT + 2, false))
                .isEqualTo(Rank.THIRD);
    }

    @DisplayName("당첨 개수가 5개 이고, 보너스 번호가 같을 경우")
    @Test
    void matchCountIs5AndBonusIsTrue() {
        assertThat(Rank.match(MINIMUM_MATCH_COUNT + 2, true))
                .isEqualTo(Rank.SECOND);
    }
}