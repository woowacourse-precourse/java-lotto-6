package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    @DisplayName("구입금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 100, 1001, 10100})
    void createPurchaseAmountByInvalidValue(int value) {
        assertThatThrownBy(
                () -> PurchaseAmount.from(value)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위로 입력해주세요.");
    }

    @DisplayName("구입금액이 1000으로 나누어 떨어지면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 99000, 123000})
    void createPurchaseAmountByValidValue(int value) {
        assertThatCode(
                () -> PurchaseAmount.from(value)
        ).doesNotThrowAnyException();
    }
}