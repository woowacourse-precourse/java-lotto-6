package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketManagerTest {

    private final LottoTicketManager lottoTicketManager = new LottoTicketManager();

    @Test
    @DisplayName("금액에 맞는 번호 갯수 반환 ")
    public void LottoTicketManagerTest() {
        assertEquals(1234,lottoTicketManager.countTickets("1234000"));
    }

}