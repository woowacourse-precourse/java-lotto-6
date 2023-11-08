package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoAmount;
import lotto.domain.LottoMachine;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine(new LottoNumberGenerator());

    @DisplayName("로또 금액에 맞게 올바른 수량의 로또가 발행되는가.")
    @Test
    void createLottosByLottoAmount() {
        int lottoPrice = 1_000;
        int lottoQuantity = 10;

        assertThat(lottoMachine.buyLottos(new LottoAmount(lottoPrice * lottoQuantity)))
                .hasSize(lottoQuantity);
    }
}
