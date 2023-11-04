package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.IssuedLottos;
import lotto.utility.vo.PurchaseAmountRequest;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    void 로또_발행하기() {
        // given
        PurchaseAmountRequest 구매금액요청 = new PurchaseAmountRequest("5000");

        // when
        IssuedLottos 발행된_로또들 = lottoService.generateLottos(구매금액요청);

        // then
        assertEquals(5, 발행된_로또들.numberOfIssuedLottos());
    }

}