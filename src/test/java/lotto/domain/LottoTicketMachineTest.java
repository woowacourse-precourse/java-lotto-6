package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.vo.request.PurchaseAmountRequest;
import org.junit.jupiter.api.Test;

class LottoTicketMachineTest {
    private final LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();

    @Test
    void 로또를_발행한다() {
        // given
        PurchaseAmountRequest 구매금액요청 = new PurchaseAmountRequest("5000");

        // when
        IssuedLottos 발행된_로또들 = lottoTicketMachine.generateLottos(구매금액요청);

        // then
        assertEquals(5, 발행된_로또들.numberOfIssuedLottos());
    }

}