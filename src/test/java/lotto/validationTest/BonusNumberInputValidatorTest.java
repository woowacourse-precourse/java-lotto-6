package lotto.validationTest;

import lotto.validation.BonusNumberInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BonusNumberInputValidatorTest {
    @DisplayName("1~45 숫자 정상 입력 테스트")
    @Test
    public void testValidBonusNumber() {
        String validBonusNumber = "7";

        assertThatCode(() -> BonusNumberInputValidator.validate(validBonusNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("시도 횟수가 0일 때 예외 처리")
    @Test
    public void testBonusNumberZero() {
        String zeroBonusNumber = "0";

        assertThatIllegalArgumentException().isThrownBy(() -> BonusNumberInputValidator.validate(zeroBonusNumber))
                .withMessage("입력값이 0이 될 수 없습니다.");
    }

    @DisplayName("숫자가 아닌 입력에 대한 예외 처리")
    @Test
    public void testNonDigitBonusNumber() {
        String nonDigitBonusNumber = "abc";

        assertThatIllegalArgumentException().isThrownBy(() -> BonusNumberInputValidator.validate(nonDigitBonusNumber))
                .withMessage("입력값이 숫자가 아닙니다.");
    }
}
