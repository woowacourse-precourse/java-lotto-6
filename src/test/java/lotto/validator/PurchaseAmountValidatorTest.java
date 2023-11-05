package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.dto.PurchaseAmountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {
    @Nested
    @DisplayName("validatePurchaseAmount 메소드 test")
    class validatePurchaseAmountTest {
        @DisplayName("구입 금액이 숫자일 경우 검증 성공")
        @Test
        void Purchase_amount_is_a_number() {
            // given
            String input1 = "1";
            String input100 = "100";
            String input1000 = "1000";

            // when
            // then
            PurchaseAmountValidator.inputValidate(input1);
            PurchaseAmountValidator.inputValidate(input100);
            PurchaseAmountValidator.inputValidate(input1000);
        }

        @DisplayName("구입 금액이 입력되지 않은 경우 예외 발생")
        @Test
        void Purchase_amount_is_empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> PurchaseAmountValidator.inputValidate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.ENTER_VALUE_MESSAGE);
        }

        @DisplayName("구입 금액이 숫자가 아닐 경우 예외 발생")
        @Test
        void Purchase_amount_is_not_a_number() {
            // given
            String input = "AAAA";

            // when
            // then
            assertThatThrownBy(() -> PurchaseAmountValidator.inputValidate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputValidator.INVALID_INPUT_CHARACTER);
        }
    }

    @Nested
    @DisplayName("validatePurchaseAmount 메소드 test")
    class ValidatePurchaseAmountDto {
        @DisplayName("구입 금액이 " + PurchaseAmountDto.PURCHASE_AMOUNT_UNIT + " 단위면 검증 통과")
        @Test
        void Amount_is_divisible_by_the_purchase_amount_unit() {
            // given
            int amount1 = 1_000;
            int amount2 = 15_000;
            int amount3 = 1_000_000;

            // when
            // then
            PurchaseAmountDto purchaseAmount1 = new PurchaseAmountDto(amount1);
            PurchaseAmountDto purchaseAmount2 = new PurchaseAmountDto(amount2);
            PurchaseAmountDto purchaseAmount3 = new PurchaseAmountDto(amount3);
        }

        @DisplayName("구입 금액이 " + PurchaseAmountDto.PURCHASE_AMOUNT_UNIT + " 단위가 아니면 예외 발생")
        @Test
        void test() {
            // given
            int amount1 = 1_001;
            int amount2 = 43_200;

            // when
            // then
            assertThatThrownBy(() -> new PurchaseAmountDto(amount1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(PurchaseAmountValidator.PURCHASE_AMOUNT_NOT_DIVISIBLE_MESSAGE);
            assertThatThrownBy(() -> new PurchaseAmountDto(amount2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(PurchaseAmountValidator.PURCHASE_AMOUNT_NOT_DIVISIBLE_MESSAGE);
        }
    }
}