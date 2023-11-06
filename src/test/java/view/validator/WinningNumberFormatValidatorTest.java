package view.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberFormatValidatorTest extends NsTest {

    private final WinningNumberFormatValidator winningNumberFormatValidator = new WinningNumberFormatValidator();
    @DisplayName("당첨 번호가 입력되지 않으면 예외 발생")
    @Test
    void winningNumberDoesntEnter() {
        assertThatThrownBy(() -> winningNumberFormatValidator.checkWinningNumberValidation(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.WINNNING_NUMBER_DOESNT_ENTER.getErrorMessage());
    }

    @Override
    public void runMain() {
    }
}