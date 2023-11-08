package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountExceptionTest {
    AmountException amountException = new AmountException();

    @Test
    @DisplayName("빈칸을 입력 하면 예외가 발생 한다.")
    void checkBlank() {
        assertThatThrownBy(() -> amountException.checkBlank(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2", "abc123", "jfk"})
    @DisplayName("음수나 정수가 아닌 값은 예외가 발생 한다.")
    void checkPositiveInteger(String input) {
        assertThatThrownBy(() -> amountException.checkPositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "2147483648"})
    @DisplayName("양의 정수 범위를 넘어 가면 예외가 발생 한다.")
    void checkOutOfIntegerRange(String input) {
        assertThatThrownBy(() -> amountException.checkPositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"999", "100001"})
    @DisplayName("로또 구매 가능 금액을 넘어 가면 예외가 발생 한다.")
    void checkLessThanMaxAmount(String price) {
        assertThatThrownBy(() -> amountException.checkLessThanMaxAmount(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkEmptySpace() {
    }

    @Test
    void checkThousandUnits() {
    }
}