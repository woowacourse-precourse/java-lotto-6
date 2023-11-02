package lotto;


import lotto.utils.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    @DisplayName("음수 금액을 입력하면 예외가 발생한다.")
    @Test
    void validateNonNegativeWithNegativeAmount() {
        int negativeAmount = -1000;
        assertThatThrownBy(() -> ValidationUtil.validateNonNegative(negativeAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 음수일 수 없습니다.");
    }

    @DisplayName("1000원 단위가 아닌 금액을 입력하면 예외가 발생한다.")
    @Test
    void validateThousandUnitWithInvalidAmount() {
        int invalidAmount = 1500;
        assertThatThrownBy(() -> ValidationUtil.validateThousandUnit(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 금액이 유효하지 않습니다. 1,000원 단위로 입력해주세요.");
    }

}