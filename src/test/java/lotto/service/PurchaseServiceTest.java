package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseServiceTest {

    @Test
    @DisplayName("구매 금액이 올바르지 않을 경우 예외 발생")
    void 구매_금액이_올바르지_않을_경우_예외_발생() {
        PurchaseService purchaseService = new PurchaseService();
        assertThrows(IllegalArgumentException.class, () -> purchaseService.buyLottoTicket("1100"));
    }

    @Test
    @DisplayName("구매 금액에 맞는 로또 티켓 생성")
    void 구매_금액에_맞는_로또_티켓_생성() {
        PurchaseService purchaseService = new PurchaseService();
        LottoTicket lottoTicket = purchaseService.buyLottoTicket("3000");
        assertEquals(3, lottoTicket.getLottoCount());
    }
}