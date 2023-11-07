package lotto;

import lotto.controller.LottoController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {
    private final LottoController lottoController = new LottoController();

    @DisplayName("1000으로 나누어떨어지지 않는 수가 들어오면 예외가 발생한다.")
    @Test
    void canDivide1000() {
        int number = 1001;

        assertThatThrownBy(() -> lottoController.getPurchaseQuantity(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 사이의 수가 들어오지 않을 경우 예외가 발생한다.")
    @Test
    void numberInOneToFortyFive() {
        int number = 0;

        assertThatThrownBy(() -> lottoController.validateBonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
