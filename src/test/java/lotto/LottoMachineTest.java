package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.LottoMachine;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @Test
    void issueLotto() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThat(lottoMachine.issueLottos(new Money(2000)).lottoBundle.size())
                .isEqualTo(2);
    }
}
