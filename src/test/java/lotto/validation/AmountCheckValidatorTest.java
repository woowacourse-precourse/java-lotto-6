package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.validation.AmountCheckValidator.*;
import static org.assertj.core.api.Assertions.*;


class AmountCheckValidatorTest {

    @Test
    @DisplayName("정상 처리")
    void 정상_처리() {
        validateAmount(1000);
        validateAmount(2000);
        validateAmount(14000);
        validateAmount(20000);
    }

    @Test
    @DisplayName("금액이 1,000원 단위가 아닐 때 예외")
    void 금액_비정상_예외() {
        assertThatThrownBy(() -> validateAmount(14400))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원 단위로 입력해 주세요");
    }
}