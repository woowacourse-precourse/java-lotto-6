package lotto.domain;

import static lotto.domain.LottoRank.FIFTH;
import static lotto.domain.LottoRank.FIRST;
import static lotto.domain.LottoRank.FOURTH;
import static lotto.domain.LottoRank.NONE;
import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {
    @DisplayName("LottoResult애서 주어진 LottoRank의 개수를 반환한다.")
    @ParameterizedTest
    @MethodSource("countArgumentsProvider")
    void count(LottoRank lottoRank, int expectedCount) {
        LottoResult lottoResult = new LottoResult(List.of(FIRST, SECOND, SECOND, THIRD, THIRD, THIRD, NONE));

        assertThat(lottoResult.count(lottoRank)).isEqualTo(expectedCount);
    }

    static Stream<Arguments> countArgumentsProvider() {
        return Stream.of(
                Arguments.of(FIRST, 1),
                Arguments.of(SECOND, 2),
                Arguments.of(THIRD, 3),
                Arguments.of(FOURTH, 0),
                Arguments.of(FIFTH, 0),
                Arguments.of(NONE, 1)
        );
    }

    @DisplayName("로또 구매 비용 대비 당첨 금액의 수익률을 계산한다.")
    @ParameterizedTest
    @MethodSource("calculatePrizeRateArgumentsProvider")
    void calculatePrizeRate(LottoResult lottoResult, double expectedPrizeRate) {
        assertThat(lottoResult.calculatePrizeRate()).isEqualTo(expectedPrizeRate);
    }

    static Stream<Arguments> calculatePrizeRateArgumentsProvider() {
        return Stream.of(
                Arguments.of(lottoResultOf(FIFTH), 100.0 * FIFTH.prize() / Lotto.PRICE),
                Arguments.of(
                        lottoResultOf(FIRST, SECOND, THIRD),
                        100.0 * (FIRST.prize() + SECOND.prize() + THIRD.prize()) / (Lotto.PRICE * 3)
                ),
                Arguments.of(
                        lottoResultOf(FIRST, SECOND, SECOND, THIRD, THIRD, THIRD, NONE),
                        100.0 * (FIRST.prize() + SECOND.prize() * 2 + THIRD.prize() * 3) / (Lotto.PRICE * 7)
                )
        );
    }

    private static LottoResult lottoResultOf(LottoRank... lottoRanks) {
        return new LottoResult(List.of(lottoRanks));
    }
}
