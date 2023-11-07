package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorCode;
import lotto.dto.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @ParameterizedTest
    @DisplayName("입력한 값이 숫자가 아닌 경우에는 예외가 발생한다.")
    @ValueSource(strings = {"2000원", "이천원"})
    public void should_throwException_when_inputIsNotNumeric(String input) {
        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_INTEGER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("입력한 값의 범위가 0보다 작거나, 최대 구매 가능 금액을 초과하면 예외가 발생한다.")
    @ValueSource(strings = {"0", "101000"})
    public void should_throwException_when_rangeInvalid(String input) {
        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("입력한 값이 1000원 단위로 떨어지지 않는다면, 예외를 발생한다.")
    @ValueSource(strings = {"1001", "999"})
    public void should_throwException_when_notDividedBy1000(String input) {
        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_DIVIDED.getMessage());
    }
}