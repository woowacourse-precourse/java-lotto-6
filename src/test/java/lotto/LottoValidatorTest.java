package lotto;

import lotto.validate.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoValidatorTest {

    @DisplayName("입력 금액이 숫자가 아닐 경우 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenPurchaseAmountIsNotNumber(){
        String input = "abc134";

        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 숫자여야 합니다.");
    }

    @DisplayName("입력 금액이 1000원 단위가 아닌 경우 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenPurchaseAmountIsNotMultipleOfThousand(){
        String input = "1500";

        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

}