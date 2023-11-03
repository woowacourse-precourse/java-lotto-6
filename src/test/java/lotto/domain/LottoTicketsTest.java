package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}