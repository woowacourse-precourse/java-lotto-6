package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StatisticsTest {

    private final WinningNumber winningNumber
            = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

    @DisplayName("로또 번호와 당첨 번호를 비교하여 당첨 내역을 구한다.")
    @ParameterizedTest
    @MethodSource("generateLottoTicketsWithRankCounts")
    void givenLottoTickets_Then_CompareResultsReturn(
            final List<Lotto> lottoTickets,
            final long[] expectedRankCounts
    ) {
        // when
        Statistics statistics = new Statistics(winningNumber, lottoTickets);
        List<WinningSummary> summaries = statistics.getResults();

        // then
        assertThat(summaries.size()).isEqualTo(5);
        long[] rankCounts = summaries.stream().mapToLong(WinningSummary::count).toArray();
        assertThat(rankCounts).containsExactly(expectedRankCounts);
    }

    public static Stream<Arguments> generateLottoTicketsWithRankCounts() {
        return Stream.of(
                Arguments.of(List.of(
                        new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                        new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                        new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                        new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                        new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                        new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                        new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                        new Lotto(List.of(1, 2, 3, 41, 42, 43))
                ), new long[]{0L, 0L, 0L, 0L, 1L})
        );
    }
}
