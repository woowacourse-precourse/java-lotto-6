package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("20개의 로또가 발행되는지 확인")
    @Test
    void testCalculateNumberOfLottoTickets() {
        int payment = 20000;
        LottoMachine lottoMachine = new LottoMachine(payment);

        int numberOfTickets = lottoMachine.getNumberOfLottoTickets();

        assertEquals(20, numberOfTickets);
    }

    @DisplayName("8000원을 입력할때 8개의 로또가 실제로 발행되었는지 확인")
    @Test
    void testCreateLotto() {
        int payment = 8000;
        LottoMachine lottoMachine = new LottoMachine(payment);

        Lottos lottos = lottoMachine.getLottos();

        int size = 0;
        for (Lotto lotto : lottos) {
            size++;
        }

        assertEquals(8, size);
    }
}