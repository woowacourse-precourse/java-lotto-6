package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final long TICKET_COUNT = 5;
    private static final long SINGLE_TICKET = 1;

    @DisplayName("올바른 개수의 로또 티켓이 생성되어야 한다.")
    @Test
    void testCorrectNumberOfLottoTicketsAreGenerated() {
        // given
        LottoFactory lottoFactory = new LottoFactory(TICKET_COUNT);

        // when
        List<Lotto> tickets = lottoFactory.getTickets();

        // then
        assertThat(tickets).hasSize((int) TICKET_COUNT);
    }

    @DisplayName("각 로또 티켓의 번호는 1부터 45 사이여야 한다.")
    @Test
    void testLottoNumbersShouldBeBetweenOneAndFortyFive() {
        // given
        LottoFactory lottoFactory = new LottoFactory(SINGLE_TICKET);

        // when
        Lotto ticket = lottoFactory.getTickets().get(0);

        // then
        assertThat(ticket.getNumbers())
                .allMatch(number -> number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX);
    }

    @DisplayName("각 로또 티켓은 정렬되어 있어야 한다.")
    @Test
    void testLottoTicketsShouldBeSorted() {
        // given
        LottoFactory lottoFactory = new LottoFactory(SINGLE_TICKET);

        // when
        Lotto ticket = lottoFactory.getTickets().get(0);

        // then
        assertThat(ticket.getNumbers()).isSorted();
    }

    @DisplayName("각 로또 티켓에는 중복된 번호가 없어야 한다.")
    @Test
    void testLottoTicketsShouldHaveUniqueNumbers() {
        // given
        LottoFactory lottoFactory = new LottoFactory(SINGLE_TICKET);

        // when
        Lotto ticket = lottoFactory.getTickets().get(0);

        // then
        Set<Integer> uniqueNumbers = new HashSet<>(ticket.getNumbers());
        assertThat(uniqueNumbers).hasSameSizeAs(ticket.getNumbers());
    }
}


