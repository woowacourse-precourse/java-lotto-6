package lotto.ViewTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.View.LottoInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoInputViewInputBonusNumberTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("숫자가 아닌 문자가 포함되었을 경우 예외가 발생한다.")
    @Test
    void createInputBonusNumberByNotNumber() {
        assertSimpleTest(() -> {
            runException("t");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("숫자와 함께 문자가 포함되어 있을 경우 예외가 발생한다")
    @Test
    void createInputBonusNumberWithCharacter() {
        assertSimpleTest(() -> {
            runException("1,");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 숫자가 당첨 숫자와 겹칠 경우 예외가 발생한다")
    @Test
    void createInputBonusNumberHavingWinningNumber() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 숫자가 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void createInputBonusNumberOutOfRange() {
        assertSimpleTest(() -> {
            runException("46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        LottoInputView lottoInputView = new LottoInputView();
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoInputView.inputBonusNumber(winningNumbers);
    };
}
