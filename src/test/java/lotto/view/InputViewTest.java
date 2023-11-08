package lotto.view;

import static lotto.constants.Message.CONTAINS_WHITESPACE;
import static lotto.constants.Message.ENDS_WITH_DELIMITER;
import static lotto.constants.Message.INVALID_NUMBER_FORMAT;
import static lotto.constants.Message.INVALID_PURCHASE_AMOUNT;
import static lotto.constants.Message.ZERO_OR_NEGATIVE_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @DisplayName("유효한 구입 금액을 입력하면 예외가 발생하지 않는다.")
    @Test
    public void testValidPurchaseAmountValid() {
        assertDoesNotThrow(() -> inputView.validatePurchaseAmount("8000"));
    }

    @DisplayName("공백을 포함한 구입 금액을 입력하면 예외가 발생한다.")
    @Test
    public void testInvalidPurchaseAmountWithBlank() {
        assertThatThrownBy(() -> inputView.validatePurchaseAmount("8000 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTAINS_WHITESPACE);
    }

    @DisplayName("숫자가 아닌 구입 금액을 입력하면 예외가 발생한다.")
    @Test
    public void testInvalidPurchaseAmountWithNonNumeric() {
        assertThatThrownBy(() -> inputView.validatePurchaseAmount("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_FORMAT);
    }

    @DisplayName("0인 구입 금액을 입력하면 예외가 발생한다.")
    @Test
    public void testInvalidPurchaseAmountWithZero() {
        assertThatThrownBy(() -> inputView.validatePurchaseAmount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ZERO_OR_NEGATIVE_NUMBER);
    }

    @DisplayName("음수인 구입 금액을 입력하면 예외가 발생한다.")
    @Test
    public void testInvalidPurchaseAmountWithNegative() {
        assertThatThrownBy(() -> inputView.validatePurchaseAmount("-8000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ZERO_OR_NEGATIVE_NUMBER);
    }

    @DisplayName("1000원 단위가 아닌 구입 금액을 입력하면 예외가 발생한다.")
    @Test
    public void testInvalidPurchaseAmountWithNotMultipleOfThousand() {
        assertThatThrownBy(() -> inputView.validatePurchaseAmount("8001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PURCHASE_AMOUNT);
    }

    @DisplayName("유효한 당첨 번호를 입력하면 예외가 발생하지 않는다.")
    @Test
    public void testValidNumbers() {
        assertDoesNotThrow(() -> inputView.validateNumbers("1,2,3,4,5,6"));
    }

    @DisplayName("구분자(,)로 끝나는 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    public void testInvalidNumbersWithEndsWithComma() {
        assertThatThrownBy(() -> inputView.validateNumbers("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENDS_WITH_DELIMITER);
    }

    @DisplayName("공백을 포함한 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    public void testInvalidNumbersWithBlank() {
        assertThatThrownBy(() -> inputView.validateNumbers("1,2,3,4,,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTAINS_WHITESPACE);
    }

    @DisplayName("숫자가 아닌 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    public void testInvalidNumbersWithNonNumeric() {
        assertThatThrownBy(() -> inputView.validateNumbers("1,2,3,4,abc,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_FORMAT);
    }

    @DisplayName("음수인 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    public void testInvalidNumbersWithNegative() {
        assertThatThrownBy(() -> inputView.validateNumbers("1,2,3,4,-5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ZERO_OR_NEGATIVE_NUMBER);
    }
}