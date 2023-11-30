package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputValidatorTest {
    private static final String CORRECT_NUMBER_TEXT = "8000";
    private static final String BLANK_TEXT = "";
    private static final String NULL_TEXT = null;
    private static final String NOT_NUMBER_TEXT = "jindding";
    private static final String UNDER_THOUSAND_TEXT = "800";
    private static final String NOT_DIVIDED_WITH_THOUSAND_TEXT = "1800";

    @Test
    @DisplayName("올바른 구입 금액을 입력받은 경우")
    void validatePurchaseAmount_validateWithCorrectNumber() {
        int purchaseAmount = UserInputValidator.validatePurchaseAmount(CORRECT_NUMBER_TEXT);
        assertThat(purchaseAmount).isEqualTo(8000);
    }

    @Test
    @DisplayName("공백을 입력받은 경우")
    void validatePurchaseAmount_validateWithBlankValue() {
        assertThatThrownBy(() -> {
            UserInputValidator.validatePurchaseAmount(BLANK_TEXT);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("Null값을 입력받은 경우")
    void validatePurchaseAmount_validateWithNullValue() {
        assertThatThrownBy(() -> {
            UserInputValidator.validatePurchaseAmount(NULL_TEXT);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 문자를 입력받은 경우")
    void validatePurchaseAmount_validateWithNotNumberValue() {
        assertThatThrownBy(() -> {
            UserInputValidator.validatePurchaseAmount(NOT_NUMBER_TEXT);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("1000원 미만의 금액을 입력받은 경우")
    void validatePurchaseAmount_validateWithUnderThousandValue() {
        assertThatThrownBy(() -> {
            UserInputValidator.validatePurchaseAmount(UNDER_THOUSAND_TEXT);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("1000원 단위로 나누어 떨어지지 않는 수를 입력받은 경우")
    void validatePurchaseAmount_validateWithNotDividedWithThousandValue() {
        assertThatThrownBy(() -> {
            UserInputValidator.validatePurchaseAmount(NOT_DIVIDED_WITH_THOUSAND_TEXT);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE.getErrorMessage());
    }
}
