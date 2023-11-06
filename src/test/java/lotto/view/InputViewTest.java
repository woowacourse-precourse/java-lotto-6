package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {

    @Test
    @DisplayName("로또 구입 금액이 숫자가 아닌 입력이 들어오면 예외가 발생한다.")
    void inputLottoPurchaseAmountByOnlyInteger() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ErrorMessage.NOT_INTEGER_LOTTO_PURCHASE_AMOUNT.getMessage());
        });
    }

    @Test
    @DisplayName("로또 구입 금액이 0으로 시작하면 예외가 발생한다.")
    void inputLottoPurchaseAmountByStartZero() {
        assertSimpleTest(() -> {
            runException("01000");
            assertThat(output()).contains(ErrorMessage.START_ZERO_LOTTO_PURCHASE_AMOUNT.getMessage());
        });
    }

    @Test
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void inputLottoPurchaseAmountByDivide1000() {
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains(ErrorMessage.NOT_DIVIDE_LOTTO_PURCHASE_MINIMUM_AMOUNT.getMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}