package lotto.domain.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoTicketList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("구매금액을 통해 n장의 로또 티켓을 구매하는 기능이다.")
    void generateLottoTicketList() {
        //given
        int numberOfTickets = 17;
        //when
        LottoTicketList lottoTicketList = LottoGenerator.generateLottoTicketList(numberOfTickets);
        Integer actualNumberOfTickets = lottoTicketList.getNumberOfTickets();
        //then
        assertThat(actualNumberOfTickets).isEqualTo(numberOfTickets);
    }

    @Test
    @DisplayName("생성된 모든 티켓의 숫자들은 모두 6개이다.")
    void generatedTicketsEquivalentTest() throws Exception{
        //given
        int numberOfTickets = 17;
        //when
        LottoTicketList lottoTicketList = LottoGenerator.generateLottoTicketList(numberOfTickets);
        List<LottoTicket> lottoTickets = lottoTicketList.getLottoTickets();

        long count = lottoTickets.stream()
                .map(e -> e.getNumbers().size())
                .filter(e -> e == 6)
                .count();
        //then
        assertThat(count).isEqualTo(17L);

    }

    @Test
    @DisplayName("생성된 티켓은 모두 1에서 45사이의 숫자이며 유일성을 보장한다.")
    void validRangeTest() throws Exception{
        //given
        int numberOfTickets = 17;
        long expectation = 17 * 6;
        //when
        LottoTicketList lottoTicketList = LottoGenerator.generateLottoTicketList(numberOfTickets);
        List<LottoTicket> lottoTickets = lottoTicketList.getLottoTickets();

        long count = lottoTickets.stream()
                .map(Lotto::getNumbers)
                .filter(this::validateUniqueList)
                .mapToLong(Collection::size)
                .sum();
        //then
        assertThat(count).isEqualTo(expectation);
    }



    private boolean validateUniqueList(List<Integer> list) {
        int distinctCount = (int) list.stream()
                .distinct()
                .count();
        return distinctCount == list.size();
    }
}