package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoGameTest {

    private final WinningNumber winningNumber
            = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

    @DisplayName("사용자로부터 로또 번호와 당첨 번호를 입력받아 당첨 내역을 구한다.")
    @ParameterizedTest
    @MethodSource("generateLottoTickets")
    void givenWinningNumberWithLottoTickets_Then_CompareResultsReturn(
            final List<Lotto> lottoTickets
    ) {
        // when
        final LottoGame lottoGame = new LottoGame(winningNumber, lottoTickets);
        final WinningDetails winningDetails = lottoGame.play();
        final List<WinningSummary> summaries = winningDetails.getResults();

        // then
        assertThat(summaries.size()).isEqualTo(5);
        final long[] rankCounts = summaries.stream().mapToLong(WinningSummary::frequency).toArray();
        assertThat(rankCounts).containsExactly(2L, 0L, 0L, 0L, 1L);
    }

    @DisplayName("로또 티켓과 당첨 번호가 주어졌을 때, 이에 대한 총 당첨 금액을 구한다.")
    @ParameterizedTest
    @MethodSource("generateLottoTickets")
    void givenWinningNumberWithLottoTickets_Then_TotalAmountReturns(
            final List<Lotto> lottoTickets
    ) {
        final LottoGame lottoGame = new LottoGame(winningNumber, lottoTickets);
        final WinningDetails winningDetails = lottoGame.play();
        final BigDecimal totalAmount = winningDetails.sumUpWinningAmount();
        assertThat(totalAmount).isEqualByComparingTo(BigDecimal.valueOf(2_000_010_000L));
    }

    public static Stream<Arguments> generateLottoTickets() {
        return Stream.of(
                Arguments.of(List.of(
                        new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                        new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                        new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                        new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                        new Lotto(List.of(2, 13, 22, 1, 38, 5)),
                        new Lotto(List.of(1, 2, 3, 41, 42, 43))
                ))
        );
    }
}
