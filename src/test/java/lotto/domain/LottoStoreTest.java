package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoStoreTest {

    @Test
    @DisplayName("구매한 티켓에 대해 유효성 검증 테스트")
    void testGetLottoTickets() {
        Money money = new Money("5000");
        LottoStore lottoStore = new LottoStore(money);

        List<Lotto> purchasedLottoTickets = lottoStore.getLottoTickets();

        for (Lotto lotto : purchasedLottoTickets) {
            lotto.validate(lotto.getNumbers());
        }
    }

    @Test
    @DisplayName("구매하는 티켓의 개수 검증 테스트")
    void testGetLottoAmounts() {
        Money money = new Money("5000");
        LottoStore lottoStore = new LottoStore(money);
        int lottoTicketCount = lottoStore.getLottoAmounts();
        assertEquals(5, lottoTicketCount);
    }
}