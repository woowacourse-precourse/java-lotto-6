package lotto;

import lotto.utils.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * LottoMachineTest
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */
class LottoMachineTest {

    @DisplayName("로또 구입 시 숫자가 아닌 값 입력 시 예외가 발생한다.")
    @Test
    void purchaseByInputOnlyNumber() {
        assertThatThrownBy(() -> ValidationUtils.validateAmount("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 시 정해진 금액 단위가 아니면 예외가 발생한다.")
    @Test
    void purchaseByInvalidAmountUnit() {
        assertThatThrownBy(() -> ValidationUtils.validateAmount("1230"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 발행 시 요청한 수량 만큼 로또가 리턴 된다.")
    @Test
    void publish() {
        LottoMachine lottoMachine = new LottoMachine();

        int quantity = 10;
        List<Lotto> lottos = lottoMachine.publish(quantity);

        assertEquals(quantity, lottos.size());
    }
}
