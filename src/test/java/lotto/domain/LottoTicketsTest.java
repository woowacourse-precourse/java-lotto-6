package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTicketsTest {

    @DisplayName("당첨 결과를 구할 수 있다.")
    @ParameterizedTest
    @MethodSource
    void getRankResult(List<Lotto> tickets, WinningTicket winningTicket, Integer[] expected) {
        LottoTickets lottoTickets = new LottoTickets(tickets, new PurchaseAmount(1000));

        Map<Rank, Integer> rankResult = lottoTickets.getRankResult(winningTicket);
        assertThat(rankResult.values()).containsExactly(expected);
    }

    private static Stream<Arguments> getRankResult() {
        return Stream.of(
                Arguments.of(
                        List.of(createLotto(1, 2, 3, 10, 11, 12),
                                createLotto(1, 2, 3, 4, 11, 12),
                                createLotto(1, 2, 3, 4, 5, 11),
                                createLotto(1, 2, 3, 4, 5, 7),
                                createLotto(1, 2, 3, 4, 5, 6)
                        ),
                        createWinningTicket(7, 1, 2, 3, 4, 5, 6),
                        new Integer[]{1, 1, 1, 1, 1}
                ),
                Arguments.of(
                        List.of(createLotto(1, 2, 3, 4, 5, 6),
                                createLotto(1, 2, 3, 4, 5, 6)
                        ),
                        createWinningTicket(7, 1, 2, 3, 4, 5, 6),
                        new Integer[]{0, 0, 0, 0, 2}
                )
        );
    }

    private static WinningTicket createWinningTicket(int bonus, Integer... nums) {
        return new WinningTicket(createLotto(nums), new LottoNumber(bonus));
    }

    private static Lotto createLotto(Integer... nums) {
        return new Lotto(Arrays.asList(nums));
    }

    @DisplayName("수익률을 구할 수 있다")
    @ParameterizedTest
    @MethodSource
    void getRateOfReturn(PurchaseAmount purchaseAmount, long totalPrize, BigDecimal expected) {
        LottoTickets lottoTickets = new LottoTickets(List.of(), purchaseAmount);

        BigDecimal actual = lottoTickets.getRateOfReturn(totalPrize);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> getRateOfReturn() {
        return Stream.of(
                Arguments.of(new PurchaseAmount(10000), 5000, new BigDecimal("50.0")),
                Arguments.of(new PurchaseAmount(8000), 5000, new BigDecimal("62.5"))
        );
    }
}
