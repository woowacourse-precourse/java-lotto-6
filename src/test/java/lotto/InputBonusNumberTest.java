package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.message.ErrorMessage.BONUS_NUMBER_RANGE;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_BONUS_NUMBER;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_MONEY;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import lotto.view.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputBonusNumberTest extends NsTest {
    Input input = new Input();

    @Test
    @DisplayName("유효한 보너스 번호 입력 테스트")
    void getValidBonusNumber_test() {
        command("7");

        assertThat(input.getValidBonusNumber()).isEqualTo(7);

    }

    @Test
    @DisplayName("숫자가 아닌 보너스 번호 입력 시 예외 테스트")
    void validateNonNumericalBonusNumber_test() {
        assertSimpleTest(() -> {
            runException("pobi");
            assertThat(output()).contains(NUMBER_FORMAT_BONUS_NUMBER.errorMessage());
        });
    }

    @Test
    @DisplayName("1~45 범위 밖의 보너스 번호 입력 시 예외 테스트")
    void validateBonusNumberRange_test() {
        assertSimpleTest(() -> {
            runException("100");
            assertThat(output()).contains(BONUS_NUMBER_RANGE.errorMessage());
        });
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    protected void runMain() {
        input.getValidBonusNumber();
    }
}
