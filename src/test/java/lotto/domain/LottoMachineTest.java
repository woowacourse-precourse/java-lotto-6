package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다.")
    @Test
    void buyLottosByAmount() {
        LottoMachine lottoMachine = new LottoMachine();

        int amount = 14000;
        List<Lotto> lottos = lottoMachine.buy(amount);

        assertThat(lottos).hasSize(14);
    }

    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void buyLottosByInvalidAmount() {
        LottoMachine lottoMachine = new LottoMachine();

        int amount = 14001;

        assertThatThrownBy(() -> lottoMachine.buy(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}