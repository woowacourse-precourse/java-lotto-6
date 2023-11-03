package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {

    @Test
    @DisplayName("지정된 금액으로 로또 티켓을 구매하면 올바른 수의 티켓이 생성됨")
    void givenAmount_whenBuy_thenCorrectNumberOfLottoTicketsCreated() {
        int purchaseAmount = 5_000;
        LottoTickets lottoTickets = LottoTickets.buy(purchaseAmount);

        assertNotNull(lottoTickets);
        assertEquals(5, lottoTickets.getLottoTickets().size());
    }

    @Test
    @DisplayName("LottoTickets에서 로또 티켓 목록을 가져오면 복사된 목록이 반환됨")
    void whenGetLottoTickets_thenReturnsCopyOfLottoTicketList() {
        int purchaseAmount = 3_000;
        LottoTickets lottoTickets = LottoTickets.buy(purchaseAmount);
        List<Lotto> originalTickets = lottoTickets.getLottoTickets();

        List<Lotto> ticketsCopy = lottoTickets.getLottoTickets();
        ticketsCopy.remove(0);

        assertNotEquals(ticketsCopy.size(), originalTickets.size(), "원본 목록과 복사된 목록의 크기가 달라야 함");
    }

}