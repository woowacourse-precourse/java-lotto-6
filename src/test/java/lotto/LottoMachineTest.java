package lotto;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.model.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    @Test
    void normal_test() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLottos(new Money(5000));

        Lottos lottos = lottoMachine.getLottos();

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }

        Assertions.assertEquals(lottos.getLottos().size(), 5);
    }

    @DisplayName("돈 에외 테스트.")
    @ParameterizedTest
    @ValueSource(ints = {0, 999, 5005})
    void buyLottosByWrongMoney(int input) {
        LottoMachine lottoMachine = new LottoMachine();
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> lottoMachine.buyLottos(new Money(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}