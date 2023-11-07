package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoCheckerTest {

    @Test
    void 당첨_번호와_보너스_번호를_티켓을_비교해_등수를_반환한다() {
        final LottoChecker lottoChecker = new LottoChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        final Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        final LottoRank lottoRank = lottoChecker.checkTicket(ticket);

        assertThat(lottoRank).isEqualTo(LottoRank.FIVE_MATCH_WITH_BONUS);
    }

    @ParameterizedTest
    @MethodSource("generateTicketNumbers")
    void 맞춘_개수가_3개보다_작다면_LESS_THREE_MATCH를_반환한다(List<Integer> ticketNumbers) {
        final LottoChecker lottoChecker = new LottoChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        final Lotto ticket = new Lotto(ticketNumbers);

        final LottoRank lottoRank = lottoChecker.checkTicket(ticket);

        assertThat(lottoRank).isEqualTo(LottoRank.LESS_THREE_MATCH);
    }

    private static Stream<List<Integer>> generateTicketNumbers() {
        return Stream.of(
            List.of(7, 8, 9, 10, 11, 12),
            List.of(1, 8, 9, 10, 11, 12),
            List.of(1, 2, 9, 10, 11, 12)
        );
    }

}