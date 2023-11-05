package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {
    @DisplayName("올바른 개수의 로또 티켓이 생성되어야 한다.")
    @Test
    void testCorrectNumberOfLottoTicketsAreGenerated() {
        // given
        long ticketCounts = 5;
        LottoFactory lottoFactory = new LottoFactory(ticketCounts);

        // when
        List<Lotto> tickets = lottoFactory.getTickets();

        // then
        assertThat(tickets).hasSize((int) ticketCounts);
    }

    @DisplayName("각 로또 티켓의 번호는 1부터 45 사이여야 한다.")
    @Test
    void testLottoNumbersShouldBeBetweenOneAndFortyFive() {
        // given
        LottoFactory lottoFactory = new LottoFactory(1);

        // when
        Lotto ticket = lottoFactory.getTickets().get(0);

        // then
        assertThat(ticket.getNumbers())
                .allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("각 로또 티켓은 정렬되어 있어야 한다.")
    @Test
    void testLottoTicketsShouldBeSorted() {
        // given
        LottoFactory lottoFactory = new LottoFactory(1);

        // when
        Lotto ticket = lottoFactory.getTickets().get(0);

        // then
        assertThat(ticket.getNumbers()).isSorted();
    }

    @DisplayName("각 로또 티켓에는 중복된 번호가 없어야 한다.")
    @Test
    void testLottoTicketsShouldHaveUniqueNumbers() {
        // given
        LottoFactory lottoFactory = new LottoFactory(1);

        // when
        Lotto ticket = lottoFactory.getTickets().get(0);

        // then
        Set<Integer> uniqueNumbers = ticket.getNumbers().stream().collect(Collectors.toSet());
        assertThat(uniqueNumbers).hasSameSizeAs(ticket.getNumbers());
    }


}

