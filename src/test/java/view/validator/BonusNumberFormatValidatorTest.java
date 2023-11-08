package view.validator;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class BonusNumberFormatValidatorTest extends NsTest {

    private final BonusNumberFormatValidator bonusNumberFormatValidator = new BonusNumberFormatValidator();

    @DisplayName("당첨 번호를 입력하지 않으면 예외 발생")
    @Test
    void bonusNumDoesntEnter() {
        assertThatThrownBy(() -> bonusNumberFormatValidator.checkBonusNumberValidation(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.BONUS_NUMBER_DOESNT_ENTER.getErrorMessage());
    }

    @Override
    public void runMain() {

    }
}