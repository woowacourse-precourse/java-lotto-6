package lotto.application;

import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @DisplayName("구입 금액에 따라 구매 가능한 로또 티켓 수를 계산한다.")
    @Test
    void calculateNumberOfLottoTicketsBasedOnPurchaseAmount() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        LottoService lottoService = new LottoService(lottoMachine);
        int purchaseAmount = 14000; // 예를 들어 14,000원이 주어졌을 때

        // when
        lottoService.purchaseLottoTickets(purchaseAmount);

        // then
        assertThat(lottoService.getLottos().size()).isEqualTo(14); // 14,000원으로 14장의 로또를 살 수 있음
    }
}