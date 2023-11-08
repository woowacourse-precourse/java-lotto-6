package lotto.domain.common;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    private static final int ONE = 1;

    @DisplayName("5등의 상금 계산")
    @Test
    void calculatePrizeTest_FIFTH() {
        Rank fifth = Rank.valueOf("FIFTH");
        Assertions.assertThat(fifth.calculatePrize(ONE)).isEqualTo(fifth.getPrize());
    }

    @DisplayName("4등의 상금 계산")
    @Test
    void calculatePrizeTest_FOURTH() {
        Rank fourth = Rank.valueOf("FOURTH");
        Assertions.assertThat(fourth.calculatePrize(ONE)).isEqualTo(fourth.getPrize());
    }

    @DisplayName("3등의 상금 계산")
    @Test
    void calculatePrizeTest_THIRD() {
        Rank third = Rank.valueOf("THIRD");
        Assertions.assertThat(third.calculatePrize(ONE)).isEqualTo(third.getPrize());
    }

    @DisplayName("2등의 상금 계산")
    @Test
    void calculatePrizeTest_SECOND() {
        Rank second = Rank.valueOf("SECOND");
        Assertions.assertThat(second.calculatePrize(ONE)).isEqualTo(second.getPrize());
    }

    @DisplayName("1등의 상금 계산")
    @Test
    void calculatePrizeTest_FIRST() {
        Rank first = Rank.valueOf("FIRST");
        Assertions.assertThat(first.calculatePrize(ONE)).isEqualTo(first.getPrize());
    }
}