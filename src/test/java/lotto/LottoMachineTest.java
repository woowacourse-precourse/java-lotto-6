package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine(new LottoNumberGenerator());

    @Test
    void 로또_수량에_맞게_로또_리스트가_생성되는가() {
        // given
        int lottoPrice = 1_000;
        int lottoQuantity = 10;

        // when
        List<Lotto> actual = lottoMachine.buyLottos(lottoPrice * lottoQuantity);

        // then
        assertThat(actual).hasSize(lottoQuantity);
    }
}
