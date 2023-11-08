package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.order.PurchaseOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    @DisplayName("구매 수량 만큼 로또를 생성한다.")
    void 구매_수량_만큼_로또를_생성한다() {
        // given
        var purchaseOrder = new PurchaseOrder(1_000);

        // when
        var lottoMachine = new LottoMachine();
        var purchasedLottos = lottoMachine.purchase(purchaseOrder);

        // then
        assertThat(purchasedLottos).hasSize(1);
    }
}
