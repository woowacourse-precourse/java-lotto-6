package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoMachine;
import lotto.util.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @DisplayName("구입 금액이 로또 가격보다 적을 경우 예외를 던진다.")
    @Test
    void purchaseLottoWithNotEnoughMoneyShouldThrowException() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.purchaseLotto(LottoConstants.LOTTO_PRICE - 1)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(LottoMachine.NOT_ENOUGH_MONEY);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외를 던진다.")
    @Test
    void purchaseLottoWithInvalidUnitOfMoneyShouldThrowException() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.purchaseLotto(LottoConstants.LOTTO_PRICE + 500)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(LottoMachine.INVALID_UNIT_OF_MONEY);
    }
}
