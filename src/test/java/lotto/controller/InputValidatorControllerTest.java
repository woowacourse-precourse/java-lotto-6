package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.controller.InputValidatorController.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorControllerTest {

    @DisplayName("돈 숫자로 입력 안됐으면 예외 발생")
    @Test
    void inputMoneyValidateTest_isMoneyDigit() {
        assertThatThrownBy(() -> inputMoneyValidate("1000K"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈 최소 범위보다 작을 경우 예외 발생")
    @Test
    void inputMoneyValidateTest_isRightRangeMoney1() {
        assertThatThrownBy(() -> inputMoneyValidate("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈 최대 범위보다 클 경우 예외 발생")
    @Test
    void inputMoneyValidateTest_isRightRangeMoney2() {
        assertThatThrownBy(() -> inputMoneyValidate("3000000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈 설정 단위로 나누어 떨어지지 않을 경우 예외 발생")
    @Test
    void inputMoneyValidateTest_isRightMoneyUnit() {
        assertThatThrownBy(() -> inputMoneyValidate("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 숫자로 입력 안됐으면 예외 발생")
    @Test
    void inputLottoNumberValidate_isAllDigit() {
        assertThatThrownBy(() -> inputLottoNumberValidate("1,2,3,4k,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호 숫자로 입력 안됐으면 예외 발생")
    @Test
    void inputLottoBonusNumberValidate_isLottoNumberDigit() {
        assertThatThrownBy(() -> inputLottoNumberValidate("11k"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
