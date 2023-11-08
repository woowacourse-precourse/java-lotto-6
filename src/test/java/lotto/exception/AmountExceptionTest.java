package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountExceptionTest {
    AmountException amountException = new AmountException();

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "      "})
    @DisplayName("빈칸을 입력 하면 예외가 발생 한다.")
    void checkBlank(String input) {
        assertThatThrownBy(() -> amountException.checkBlank(input))
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

    @ParameterizedTest
    @ValueSource(strings = {"1 2 3 4 5", "12 34"})
    @DisplayName("입력에 공백이 있으면 예외가 발생 한다.")
    void checkEmptySpace(String input) {
        assertThatThrownBy(() -> amountException.checkEmptySpace(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "5100", "2020"})
    @DisplayName("금액이 1,000단위가 아니면 예외가 발생 한다.")
    void checkThousandUnits(String input) {
        assertThatThrownBy(() -> amountException.checkThousandUnits(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}