package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Nested
    @DisplayName("validatePurchaseAmount 메소드 test")
    class validatePurchaseAmountTest {

        @DisplayName("구입 금액이 숫자일 경우 검증 성공")
        @Test
        void Purchase_amount_is_a_number() {
            // given
            String input = "1000";

            // when
            // then
            InputValidator.validatePurchaseAmount(input);
        }

        @DisplayName("구입 금액이 숫자가 아닐 경우 예외 발생")
        @Test
        void Purchase_amount_is_not_a_number() {
            // given
            String input = "AAAA";

            // when
            // then
            assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.WRONG_INPUT_PURCHASE_AMOUNT_MESSAGE);
        }
    }
}