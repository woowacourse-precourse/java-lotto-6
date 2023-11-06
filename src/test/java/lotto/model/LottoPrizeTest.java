package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.model.result.LottoMatchResult;

class LottoPrizeTest {

    @DisplayName("주어진 로또 판별 결과에 대해 당첨 등수를 판별한다.")
    @ParameterizedTest
    @MethodSource("getLottoMatchResultsAndPrize")
    void createLottoPrize(LottoMatchResult result, LottoPrize prize) {
        assertThat(LottoPrize.from(result)).isSameAs(prize);
    }

    private static Stream<Arguments> getLottoMatchResultsAndPrize() {
        return Stream.of(
                Arguments.of(new LottoMatchResult(6, false), LottoPrize.PRIZE_1),
                Arguments.of(new LottoMatchResult(5, true), LottoPrize.PRIZE_2),
                Arguments.of(new LottoMatchResult(5, false), LottoPrize.PRIZE_3),
                Arguments.of(new LottoMatchResult(4, false), LottoPrize.PRIZE_4),
                Arguments.of(new LottoMatchResult(3, false), LottoPrize.PRIZE_5),
                Arguments.of(new LottoMatchResult(2, false), LottoPrize.NO_PRIZE),
                Arguments.of(new LottoMatchResult(1, true), LottoPrize.NO_PRIZE),
                Arguments.of(new LottoMatchResult(0, false), LottoPrize.NO_PRIZE)
        );
    }
}
