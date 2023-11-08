package lotto.util.validator;

import lotto.util.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PurchaseValidatorTest {
    @Test
    @DisplayName("유효한 구매 금액을 검증할 수 있다.")
    void validatePurchaseAmount() {
        PurchaseValidator purchaseValidator = new PurchaseValidator();

        String validAmount = "5000";
        long result = purchaseValidator.validatePurchaseAmount(validAmount);

        assertThat(result).isEqualTo(5000);
    }

    @Test
    @DisplayName("구매 금액이 null 또는 빈 문자열일 때 예외를 던진다.")
    void validateNullorEmpty() {
        PurchaseValidator purchaseValidator = new PurchaseValidator();

        assertThatThrownBy(() -> purchaseValidator.validatePurchaseAmount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_PURCHASE_AMOUNT.getMessage());

        assertThatThrownBy(() -> purchaseValidator.validatePurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("구매 금액이 숫자 형식이 아닐 때 예외를 던진다.")
    void validateNumberType() {
        PurchaseValidator purchaseValidator = new PurchaseValidator();

        assertThatThrownBy(() -> purchaseValidator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());

        assertThatThrownBy(() -> purchaseValidator.validatePurchaseAmount("1.23"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("구매 금액이 0 또는 음수일 때 예외를 던진다.")
    void validateAmountPositive() {
        PurchaseValidator purchaseValidator = new PurchaseValidator();

        assertThatThrownBy(() -> purchaseValidator.validatePurchaseAmount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());

        assertThatThrownBy(() -> purchaseValidator.validatePurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("구매 금액이 1,000원 단위가 아닐 때 예외를 던진다.")
    void validateAmountFormate() {
        PurchaseValidator purchaseValidator = new PurchaseValidator();

        assertThatThrownBy(() -> purchaseValidator.validatePurchaseAmount("1501"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());

        assertThatThrownBy(() -> purchaseValidator.validatePurchaseAmount("2503"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());
    }
}