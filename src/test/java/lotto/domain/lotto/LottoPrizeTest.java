package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class LottoPrizeTest {
    @DisplayName("matchedCount가 6~3 범위이고, bonusNumber가 없으면 2등을 제외한 1~5등을 결과로 반환")
    @Test
    void of_withMatchedCountSixToThreeAndNotHasBonusNumber_shouldReturnLottoPrize() {
        // given
        // when
        final LottoPrize first = LottoPrize.of(6, false);
        final LottoPrize third = LottoPrize.of(5, false);
        final LottoPrize fourth = LottoPrize.of(4, false);
        final LottoPrize fifth = LottoPrize.of(3, false);

        // then
        assertThat(first).isEqualTo(LottoPrize.FIRST);
        assertThat(third).isEqualTo(LottoPrize.THIRD);
        assertThat(fourth).isEqualTo(LottoPrize.FOURTH);
        assertThat(fifth).isEqualTo(LottoPrize.FIFTH);
    }

    @DisplayName("matchedCount가 5, bonusNumber가 있으면 2등을 결과로 반환")
    @Test
    void of_withMatchedCountFiveAndHasBonusNumber_shouldReturnSecondLottoPrize() {
        // given
        // when
        final LottoPrize second = LottoPrize.of(5, true);

        // then
        assertThat(second).isEqualTo(LottoPrize.SECOND);
    }

    @DisplayName("matchedCount가 그 외 범위이면 항상 NONE을 결과로 반환")
    @Test
    void of_extraMatchedCount_shouldReturnNone() {
        // given
        // when
        final LottoPrize lottoPrize1 = LottoPrize.of(0, true);
        final LottoPrize lottoPrize2 = LottoPrize.of(0, false);
        final LottoPrize lottoPrize3 = LottoPrize.of(7, true);
        final LottoPrize lottoPrize4 = LottoPrize.of(7, false);

        // then
        assertThat(lottoPrize1).isEqualTo(LottoPrize.X);
        assertThat(lottoPrize2).isEqualTo(LottoPrize.X);
        assertThat(lottoPrize3).isEqualTo(LottoPrize.X);
        assertThat(lottoPrize4).isEqualTo(LottoPrize.X);
    }
}