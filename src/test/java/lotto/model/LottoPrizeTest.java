package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPrizeTest {

    @ParameterizedTest
    @MethodSource("provideLottoPrizeCases")
    void 일치하는_번호의_개수와_보너스번호_일치여부에_따라_당첨상품을_추려낸다(
            int requiredMatchingNumbers, boolean isBonusNumberRequired, LottoPrize expectedLottoPrize) {
        LottoPrize actualLottoPrize = LottoPrize.of(requiredMatchingNumbers, isBonusNumberRequired);

        assertThat(actualLottoPrize).isEqualTo(expectedLottoPrize);
    }

    @ParameterizedTest
    @MethodSource("provideCountsForPrizeCalculation")
    void 당첨상품과_당첨횟수에_따라서_당첨_총_금액을_계산한다(
            LottoPrize lottoPrize, long prizeCount, long expectedPrizeAmount) {
        long actualPrizeAmount = lottoPrize.calculatePrizeAmount(prizeCount);

        assertThat(actualPrizeAmount).isEqualTo(expectedPrizeAmount);
    }

    @Test
    void 당첨상품과_당첨횟수에_따라서_당첨_총_금액을_계산할때_당첨횟수가_NULL이면_0원을_반환한다() {
        long actualPrizeAmount = LottoPrize.FIRST_PRIZE.calculatePrizeAmount(null);

        assertThat(actualPrizeAmount).isEqualTo(0L);
    }

    @Test
    void 로또상품이_두번째_상금이면_참을_반환한다() {
        boolean isSecondPrize = LottoPrize.SECOND_PRIZE.isSecondPrize();

        assertThat(isSecondPrize).isTrue();
    }

    @Test
    void 로또상품이_두번째_상금이_아니면_거짓을_반환한다() {
        boolean isSecondPrize = LottoPrize.FIRST_PRIZE.isSecondPrize();

        assertThat(isSecondPrize).isFalse();
    }

    @ParameterizedTest
    @MethodSource("provideWinningPrizeCases")
    void 로또상품이_당첨상품이면_참을_반환한다(LottoPrize lottoPrize) {
        boolean isWinningPrize = lottoPrize.isWinningPrize();

        assertThat(isWinningPrize).isTrue();
    }

    @Test
    void 로또상품이_당첨상품이_아니면_거짓을_반환한다() {
        boolean isWinningPrize = LottoPrize.NOTHING.isWinningPrize();

        assertThat(isWinningPrize).isFalse();
    }

    @Test
    void 같은_당첨상품이면_서로_같은_객체이다() {
        LottoPrize actualLottoPrize = LottoPrize.FIRST_PRIZE;
        LottoPrize expectedLottoPrize = LottoPrize.FIRST_PRIZE;

        assertThat(actualLottoPrize).isSameAs(expectedLottoPrize);
    }

    @Test
    void 같은_당첨상품이면_서로_같은_해시코드를_가진다() {
        LottoPrize actualLottoPrize = LottoPrize.FIRST_PRIZE;
        LottoPrize expectedLottoPrize = LottoPrize.FIRST_PRIZE;

        assertThat(actualLottoPrize).hasSameHashCodeAs(expectedLottoPrize);
    }

    private static Stream<Arguments> provideWinningPrizeCases() {
        return Stream.of(
                Arguments.of(LottoPrize.FIFTH_PRIZE),
                Arguments.of(LottoPrize.FOURTH_PRIZE),
                Arguments.of(LottoPrize.THIRD_PRIZE),
                Arguments.of(LottoPrize.SECOND_PRIZE),
                Arguments.of(LottoPrize.FIRST_PRIZE)
        );
    }

    private static Stream<Arguments> provideLottoPrizeCases() {
        return Stream.of(
                Arguments.of(0, false, LottoPrize.NOTHING),
                Arguments.of(3, false, LottoPrize.FIFTH_PRIZE),
                Arguments.of(4, false, LottoPrize.FOURTH_PRIZE),
                Arguments.of(5, false, LottoPrize.THIRD_PRIZE),
                Arguments.of(5, true, LottoPrize.SECOND_PRIZE),
                Arguments.of(6, false, LottoPrize.FIRST_PRIZE)
        );
    }

    private static Stream<Arguments> provideCountsForPrizeCalculation() {
        return Stream.of(
                Arguments.of(LottoPrize.NOTHING, 1L, 0L),
                Arguments.of(LottoPrize.FIFTH_PRIZE, 1L, 5_000L),
                Arguments.of(LottoPrize.FOURTH_PRIZE, 1L, 50_000L),
                Arguments.of(LottoPrize.THIRD_PRIZE, 1L, 1_500_000L),
                Arguments.of(LottoPrize.SECOND_PRIZE, 1L, 30_000_000L),
                Arguments.of(LottoPrize.FIRST_PRIZE, 1L, 2_000_000_000L)
        );
    }
}
