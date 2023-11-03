package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void normal_test() {
        LottoMachine lottoMachine = new LottoMachine(new Money(5000));
        Lottos lottos = lottoMachine.getLottos();

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }

        Assertions.assertEquals(lottos.getLottos().size(), 5);
    }

}