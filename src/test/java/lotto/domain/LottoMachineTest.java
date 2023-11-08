package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("로또 기계를 통해 장당 1000원 만큼의 로또들를 발급받는다.")
    @Test
    void test() {
        // given
        int purchaseAmount = 6000;
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        // when
        int lottoCount = lottoMachine.getLottos().size();

        //then
        Assertions.assertThat(lottoCount).isEqualTo(6);
    }
}