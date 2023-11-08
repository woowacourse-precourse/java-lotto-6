package lotto.model;

import lotto.constant.IntConstants;
import lotto.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {

    @DisplayName("올바른 값을 입력하면 성공")
    @Test
    void inputRight() {
        String inputValue = "4000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputValue);
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(4000);
    }

    @DisplayName("빈 칸을 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "1h"})
    void inputNotNumber(String inputValue) {
        assertThatThrownBy(() -> new PurchaseAmount(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("0보다 작은 숫자를 입력하면 예외 발생")
    @Test
    void inputUnderZero() {
        String inputValue = "-1000";
        assertThatThrownBy(() -> new PurchaseAmount(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_LESS_THAN_ZERO_MESSAGE.getMessage());
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 수를 입력하면 예외 발생")
    @Test
    void inputNotMultipleOfUnits() {
        String inputValue = "1001";
        Object[] values = {IntConstants.PURCHASE_AMOUNT_UNIT.getValue()};
        assertThatThrownBy(() -> new PurchaseAmount(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_MULTIPLE_OF_UNIT_MESSAGE.getMessage(values));
    }
}
