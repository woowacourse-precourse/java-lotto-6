package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoAmount;
import lotto.domain.LottoMachine;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine(new LottoNumberGenerator());

    @Test
    void 로또_수량에_맞게_로또_리스트가_생성되는가() {
        int lottoPrice = 1_000;
        int lottoQuantity = 10;

        assertThat(lottoMachine.buyLottos(new LottoAmount(lottoPrice * lottoQuantity)))
                .hasSize(lottoQuantity);
    }
}
