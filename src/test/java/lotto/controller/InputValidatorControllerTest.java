package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.controller.InputValidatorController.inputMoneyValidate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorControllerTest {

    @DisplayName("돈 숫자로 입력됐는지 확인")
    @Test
    void inputMoneyValidateTest_isMoneyDigit() {
        assertThatThrownBy(() -> inputMoneyValidate("1000K"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈 범위 확인")
    @Test
    void inputMoneyValidateTest_isRightRangeMoney() {
        assertThatThrownBy(() -> inputMoneyValidate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈 단위 확인")
    @Test
    void inputMoneyValidateTest_isRightMoneyUnit() {
        assertThatThrownBy(() -> inputMoneyValidate("3000000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
