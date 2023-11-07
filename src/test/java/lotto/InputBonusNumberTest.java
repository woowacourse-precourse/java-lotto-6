package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputBonusNumberTest extends NsTest {
    @DisplayName("보너스 번호가 공백인 경우 예외가 발생한다.")
    @Test
    void inputBlankBonusNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", " ");
            assertThat(output()).contains(ErrorMessage.NOT_NUMERIC.getMessage());
        });
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void inputNotNumericBonusNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "w");
            assertThat(output()).contains(ErrorMessage.NOT_NUMERIC.getMessage());
        });
    }

    @DisplayName("보너스 번호가 1 미만인 경우 예외가 발생한다.")
    @Test
    void inputBonusNumberUnderMin() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ErrorMessage.INVALID_RANGE.getMessage());
        });
    }

    @DisplayName("보너스 번호가 45를 초과한 경우 예외가 발생한다.")
    @Test
    void inputBonusNumberOverMax() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "59");
            assertThat(output()).contains(ErrorMessage.INVALID_RANGE.getMessage());
        });
    }

    @DisplayName("보너스 번호가 이미 당첨 번호에 있는 경우 예외가 발생한다.")
    @Test
    void inputDuplicateBonusNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "4");
            assertThat(output()).contains(ErrorMessage.HAVE_DUPLICATE_BONUS_NUMBER.getMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
