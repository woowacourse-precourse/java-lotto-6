package lotto.util;

import static lotto.util.InputValidator.validatePurchaseAmount;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("구매 금익이 공백일 때 오류 발생")
    @Test
    void validateInputEmpty(){
        assertThatThrownBy(()->validatePurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 입력 값은 공백일 수 없습니다");
    }
}