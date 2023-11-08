package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.caclulator.LottoResultCalculator;
import lotto.domain.dto.LottoResults;
import lotto.domain.model.Lottos;
import lotto.domain.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class LottoResultsTest {

    @Test
    @DisplayName("로또 결과 확인 테스트")
    public void CalculateResultsTest() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11))
        ));

        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        LottoResults results = LottoResultCalculator.calculateResults(lottos, winningNumbers);
        assertThat(results.rankCounts().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(results.rankCounts().get(LottoRank.SECOND)).isEqualTo(0);
        assertThat(results.rankCounts().get(LottoRank.THIRD)).isEqualTo(2);
        assertThat(results.rankCounts().get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(results.rankCounts().get(LottoRank.FIFTH)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("로또 수익 합 확인 테스트")
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
                Arguments.of(new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7),
                        2001500000L),
                Arguments.of(new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 10)), 7),
                        3000000L),
                Arguments.of(new WinningNumbers(new Lotto(List.of(1, 2, 3, 8, 10, 30)), 7),
                        5000L + 50000L)
        );
    }
}