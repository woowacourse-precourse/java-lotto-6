package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomerTest {

    @DisplayName("숫자로만 이루어진 문자열이 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000j", "12t"})
    void occurNotMadeNumberException(String arg0) {
        assertThatThrownBy(() -> Customer.create(arg0)).isInstanceOf(
            NumberFormatException.class);
    }
}