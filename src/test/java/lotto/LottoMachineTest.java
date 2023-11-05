package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {
    LottoMachine machine = new LottoMachine();

    @DisplayName("랜덤 로또가 제대로 생성된다.")
    @Test
    void publishRandomLottoTest() {
        assertThatNoException().isThrownBy(machine::publishRandomLotto);
    }

    @DisplayName("1000 단위가 아닌 금액으로 구매하면 예외를 발생시킨다.")
    @Test
    void purchaseWithNon1000Unit() {
        assertThatThrownBy(() -> machine.purchaseLottos(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachine.ERROR_MESSAGE_NOT_FIT_COST);
    }

    @DisplayName("1000 단위 금액으로 복권을 제대로 구매할 수 있다.")
    @Test
    void purchaseWith1000Unit() {
        List<Lotto> lottos = machine.purchaseLottos(5000);

        assertThat(lottos).hasSize(5);
    }

    @DisplayName("0원 이하 금액으로 구매시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000})
    void purchaseWithMoneyUnderZero(int money) {
        assertThatThrownBy(() -> machine.purchaseLottos(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachine.ERROR_MESSAGE_MONEY_UNDER_ZERO);
    }
}
