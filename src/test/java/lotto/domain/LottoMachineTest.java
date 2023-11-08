package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @DisplayName("로또 기계를 통해 장당 1000원 만큼의 로또들를 발급받는다.")
    @Test
    void createLottoMachine() {
        // given
        int purchaseAmount = 6000;
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        // when
        int lottoCount = lottoMachine.getLottos().size();

        // then
        assertThat(lottoCount).isEqualTo(6);
    }

    @DisplayName("구매 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void purchaseAmountIsNot1000WonPerTicket() {
        // given
        int purchaseAmount = 1234;

        // when, then
        assertThatThrownBy(() -> new LottoMachine(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}