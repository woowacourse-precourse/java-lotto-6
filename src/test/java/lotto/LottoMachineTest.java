package lotto;

import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @DisplayName("로또 금액의 배수가 아니면 예외가 발생한다")
    @Test
    void purchaseMoneyNotDivideByLottoPrice() {
        assertThatThrownBy(() -> new LottoMachine(10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
