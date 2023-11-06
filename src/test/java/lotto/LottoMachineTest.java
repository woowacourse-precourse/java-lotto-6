package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine(new LottoNumberGenerator());

    @Test
    void 구입_금액에_맞게_로또_수량이_결정되는가() {
        int lottoPrice = 1_000;
        int lottoQuantity = 10;

        assertThat(
                lottoMachine.calculateLottoQuantity(lottoPrice * lottoQuantity))
                .isEqualTo(lottoQuantity);
    }
}
