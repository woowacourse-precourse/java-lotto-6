package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoRankTest {
    @Test
    @DisplayName("1등 제대로 반환하는지 테스트")
    void 로또_1등_테스트() {
        int match = 6;
        boolean bonus = false;

        Assertions.assertThat(LottoRank.whichRank(match,bonus))
                .isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("2등 제대로 반환하는지 테스트")
    void 로또_2등_테스트() {
        int match = 5;
        boolean bonus = true;

        Assertions.assertThat(LottoRank.whichRank(match,bonus))
                .isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("3등 제대로 반환하는지 테스트")
    void 로또_3등_테스트() {
        int match = 5;
        boolean bonus = false;

        Assertions.assertThat(LottoRank.whichRank(match,bonus))
                .isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("4등 제대로 반환하는지 테스트")
    void 로또_4등_테스트() {
        int match = 4;
        boolean bonus = false;

        Assertions.assertThat(LottoRank.whichRank(match,bonus))
                .isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("꽝 제대로 반환하는지 테스트")
    void 로또_꽝_테스트() {
        int match = 2;
        boolean bonus = false;

        Assertions.assertThat(LottoRank.whichRank(match,bonus))
                .isEqualTo(LottoRank.LOSE);
    }

    @Test
    @DisplayName("5등 제대로 반환하는지 테스트")
    void 로또_5등_테스트() {
        int match = 3;
        boolean bonus = true;

        Assertions.assertThat(LottoRank.whichRank(match,bonus))
                .isEqualTo(LottoRank.FIFTH);
    }
}
