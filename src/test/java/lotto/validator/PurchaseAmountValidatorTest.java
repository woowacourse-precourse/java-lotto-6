package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {

    @Test
    @DisplayName("구입 금액을 입력하고 유효성을 검사")
    void parseAndValidatePurchaseAmount() {
        // 유효한 구입 금액인 경우
        String validInput = "5000";
        int validAmount = PurchaseAmountValidator.parseAndValidatePurchaseAmount(validInput);
        assertEquals(5000, validAmount);

        // 1000원 미만인 경우
        String lessThanMinimumInput = "500";
        IllegalArgumentException lessThanMinimumException = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(lessThanMinimumInput));
        assertEquals("[ERROR] 최소 구입 금액은 1000원입니다.", lessThanMinimumException.getMessage());

        // 1000원 단위가 아닌 경우
        String nonMultipleOf1000Input = "2500";
        IllegalArgumentException nonMultipleOf1000Exception = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(nonMultipleOf1000Input));
        assertEquals("[ERROR] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어져야 합니다.", nonMultipleOf1000Exception.getMessage());

        // 숫자가 아닌 입력인 경우
        String nonNumericInput = "abc";
        IllegalArgumentException nonNumericException = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(nonNumericInput));
        assertEquals("[ERROR] 올바른 금액을 입력해 주세요.", nonNumericException.getMessage());
    }
}
