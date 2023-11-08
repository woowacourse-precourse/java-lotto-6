package lotto.module.store;

import lotto.module.domain.PurchaseAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTicketQuantityCalculatorTest {

    @Test
    void 복권_수량_계산_성공_테스트() {
        // given
        LottoTicketQuantityCalculator lottoTicketQuantityCalculator = LottoTicketQuantityCalculator.newInstance();
        PurchaseAmount purchaseAmount = PurchaseAmount.newInstance(5000);
        int expectedCount = 5;

        // when
        int ticketCount = lottoTicketQuantityCalculator.computeLottoTicketCount(purchaseAmount);

        // then
        Assertions.assertThat(ticketCount)
                .isEqualTo(expectedCount);
    }

}