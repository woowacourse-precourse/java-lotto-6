package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomerTest {

    @DisplayName("숫자로만 이루어진 문자열이 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000j", "12t"})
    void occurNotMadeNumberException(String buyPrice) {
        assertThatThrownBy(() -> Customer.create(buyPrice)).isInstanceOf(
            NumberFormatException.class);
    }
    @DisplayName("입력한 금액이 1000원 미만일경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"900", "999"})
    void occur1000LessThanException(String buyPrice) {
        assertThatThrownBy(() -> Customer.create(buyPrice)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액이 1000원 단위가 아닐경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1010", "9100"})
    void occur1000UnitException(String buyPrice) {
        assertThatThrownBy(() -> Customer.create(buyPrice)).isInstanceOf(
            IllegalArgumentException.class);
    }
}