package domain;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResultCalculator;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class LottoResultsTest {

    @Test
    public void shouldCalculateResultsCorrectly() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11)) // 3등
        ));

        WinningNumbers winningNumbers = WinningNumbers.of("1,2,3,4,5,6", 7);

        LottoResults results = LottoResultCalculator.calculateResults(lottos, winningNumbers);
        assertThat(results.rankCounts().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(results.rankCounts().get(LottoRank.SECOND)).isEqualTo(null);
        assertThat(results.rankCounts().get(LottoRank.THIRD)).isEqualTo(2);
        assertThat(results.rankCounts().get(LottoRank.FOURTH)).isEqualTo(null);
        assertThat(results.rankCounts().get(LottoRank.FIFTH)).isEqualTo(null);
    }

    @ParameterizedTest
    @MethodSource("provideDataForTotalEarningsTest")
    void testCalculateTotalEarnings(WinningNumbers winningNumbers, long expectedTotalEarnings) {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 30));
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        LottoResults results = LottoResultCalculator.calculateResults(lottos, winningNumbers);
        long totalEarnings = results.calculateTotalEarnings();
        assertThat(totalEarnings).isEqualTo(expectedTotalEarnings);
    }

    private static Stream<Arguments> provideDataForTotalEarningsTest() {
        return Stream.of(
                Arguments.of(WinningNumbers.of("1,2,3,4,5,6", 7), 2001500000L),
                Arguments.of(WinningNumbers.of("1,2,3,4,5,10", 7), 3000000L),
                Arguments.of(WinningNumbers.of("1,2,3,8,10,30", 7),
                        5000L + 50000L)
        );
    }
}