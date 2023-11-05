package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.service.LottoService;

class LottosTest {

    LottoService lottoService = new LottoService();

    @DisplayName("구입금액만큼의 로또 발행")
    @Test
    void createLottos() {
        // given
        PurchaseAmount amount = PurchaseAmount.from(10000);

        int expect = 10;

        // when
        Lottos lottos = lottoService.generateLottos(amount);

        // then
        assertThat(lottos.size()).isEqualTo(expect);
    }
}
