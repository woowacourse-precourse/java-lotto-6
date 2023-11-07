package lotto.ViewTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.View.LottoInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoInputViewInputWinningNumberTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("숫자가 아닌 문자가 포함되었을 경우 예외가 발생한다.")
    @Test
    void createInputWinningNumbersByNotNumber() {
        assertSimpleTest(() -> {
            runException("1,2,t,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("6자리가 아닐 경우 예외가 발생한다")
    @Test
    void createInputWinningNumbersByNotSix() {
        assertSimpleTest(() -> {
            runException("1,2,3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("쉼표만 입력했을 경우 예외가 발생한다")
    @Test
    void createInputWinningNumbersWithComma() {
        assertSimpleTest(() -> {
            runException(",");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("1~45가 아닌 숫자가 포함되었을 경우 예외가 발생한다")
    @Test
    void createInputWinningNumbersOutOfRange() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        LottoInputView lottoInputView = new LottoInputView();
        lottoInputView.inputWinningNumbers();
    };
}
