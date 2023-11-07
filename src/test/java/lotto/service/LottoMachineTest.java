package lotto.service;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LottoMachineTest {
    @DisplayName("티켓 개수만큼 로또가 생성되고, 생성된 로또를 모은 로또 티켓이 발행된다.")
    @Test
    public void createLottoTicket() {
        LottoTicket lottoTicket = LottoMachine.createLottoTicket(10);
        assertNotNull(lottoTicket);
        assertEquals(10, lottoTicket.getSize());
    }
}
