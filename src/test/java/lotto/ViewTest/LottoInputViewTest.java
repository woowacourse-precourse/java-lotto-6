package lotto.ViewTest;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.View.LottoInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoInputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("숫자가 아닌 금액이 포함되었을 경우 예외가 발생한다.")
    @Test
    void createInputCashByNotNumber() {
        assertSimpleTest(() -> {
            runException("7500t");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createInputCashByNotUnitCash() {
        assertSimpleTest(() -> {
            runException("7500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("금액이 음수일 경우 예외가 발생한다.")
    @Test
    void createInputCashByMinus() {
        assertSimpleTest(() -> {
            runException("-5000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("과도한 금액을 입력했을 경우 예외가 발생한다.")
    @Test
    void createInputCashByBigCash() {
        assertSimpleTest(() -> {
            runException("2147483648");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        LottoInputView lottoInputView = new LottoInputView();
        lottoInputView.inputCash();
    };
}
