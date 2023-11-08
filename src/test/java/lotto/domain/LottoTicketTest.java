package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    @DisplayName("로또 티켓은 요청된 수만큼의 로또를 발행해야 한다")
    @Test
    void issueCorrectNumberOfLottos() {
        // given
        int numberOfTickets = 5;
        LottoTicket lottoTicket = new LottoTicket(numberOfTickets);

        // when
        List<Lotto> issuedLottos = lottoTicket.issueTickets(numberOfTickets);

        // then
        assertEquals(numberOfTickets, issuedLottos.size());
    }

    @DisplayName("발행된 로또 번호는 1과 45 사이여야 한다")
    @RepeatedTest(10)
    void issueNumbersWithinRange() {
        // given
        LottoTicket lottoTicket = new LottoTicket(1);

        // when
        Lotto lotto = lottoTicket.issueTickets(1).get(0);

        // then
        assertThat(lotto.getNumbers())
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
    }

    @DisplayName("발행된 로또 번호는 중복되지 않아야 한다")
    @RepeatedTest(10)
    void issueUniqueNumbers() {
        // given
        LottoTicket lottoTicket = new LottoTicket(1);

        // when
        Lotto lotto = lottoTicket.issueTickets(1).get(0);
        Set<Integer> uniqueNumbers = new HashSet<>(lotto.getNumbers());

        // then
        assertEquals(LOTTO_NUMBER_COUNT, uniqueNumbers.size());
    }

    @DisplayName("발행된 로또 번호는 오름차순으로 정렬되어야 한다")
    @RepeatedTest(10)
    void sortedInAscendingOrder() {
        // given
        int numberOfTickets = 1;
        LottoTicket lottoTicket = new LottoTicket(numberOfTickets);

        // when
        Lotto issuedLotto = lottoTicket.issueTickets(numberOfTickets).get(0);

        // then
        assertThat(issuedLotto.getNumbers()).isSorted();
    }

}