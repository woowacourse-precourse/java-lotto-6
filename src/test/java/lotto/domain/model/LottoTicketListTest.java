package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketListTest {

    @Test
    @DisplayName("발행된 티켓의 갯수를 확인해는 테스트")
    void getNumberOfTicketsTest() throws Exception{
        //given
        List<LottoTicket> lottoTickets = IntStream.range(0, 10)
                .mapToObj(e -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .map(LottoTicket::new)
                .toList();
        //when
        LottoTicketList lottoTicketList = new LottoTicketList(lottoTickets);
        Integer numberOfTickets = lottoTicketList.getNumberOfTickets();
        //then
        assertThat(numberOfTickets).isEqualTo(10);
    }
    @Test
    @DisplayName("getter로 참조되는 로또 티켓의 값을 비교해본다.")
    void getLottoTicketsTest() {
        //given
        List<LottoTicket> lottoTickets = IntStream.range(0, 20)
                .mapToObj(e -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .map(LottoTicket::new)
                .toList();
        //when
        LottoTicketList lottoTicketList = new LottoTicketList(lottoTickets);
        List<LottoTicket> reference = lottoTicketList.getLottoTickets();
        //then
        assertThat(reference).isEqualTo(lottoTickets);
    }


}