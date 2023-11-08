package lotto.model;

import static lotto.model.LottoPrize.FIFTH_PRIZE;
import static lotto.model.LottoPrize.FIRST_PRIZE;
import static lotto.model.LottoPrize.FOURTH_PRIZE;
import static lotto.model.LottoPrize.SECOND_PRIZE;
import static lotto.model.LottoPrize.THIRD_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.fixture.LottosFixture;
import lotto.fixture.WinningNumbersFixture;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class LottoPrizeCalculatorTest {

    @Test
    void 당첨된_당첨금의_총액을_계산한다() {
        // given
        Lottos lottos = LottosFixture.createLottos(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbersFixture.createWinningNumbers("1,2,3,4,5,6", "7");
        LottoPrizeCalculator lottoPrizeCalculator = new LottoPrizeCalculator(lottos, winningNumbers);

        // when
        long totalPrize = lottoPrizeCalculator.calculateTotalPrize();

        // then
        assertThat(totalPrize).isEqualTo(2_000_000_000);
    }

    @MethodSource("provideLottoNumbers")
    @ParameterizedTest
    void 구매한_로또의_당첨_통계를_반환한다(final List<Integer> numbers, final LottoPrize expectedLottoPrize,
                             final long expectedCount) {
        // given
        Lottos lottos = LottosFixture.createLottos(numbers);
        WinningNumbers winningNumbers = WinningNumbersFixture.createWinningNumbers("1,2,3,4,5,6", "7");
        LottoPrizeCalculator lottoPrizeCalculator = new LottoPrizeCalculator(lottos, winningNumbers);

        // when
        Map<LottoPrize, Long> winningStatistics = lottoPrizeCalculator.getWinningStatistics();

        // then
        assertThat(winningStatistics).containsEntry(expectedLottoPrize, expectedCount);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), FIRST_PRIZE, 1L),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), SECOND_PRIZE, 1L),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), THIRD_PRIZE, 1L),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), FOURTH_PRIZE, 1L),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), FIFTH_PRIZE, 1L)
        );
    }
}
