package lotto.exception;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AmountExceptionTest {
    AmountException amountException = new AmountException();

    @Test
    @DisplayName("빈칸을 입력하면 예외가 발생한다.")
    void checkBlank() {
        assertThatThrownBy(() -> amountException.checkBlank(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2", "abc123", "jfk"})
    @DisplayName("음수나 정수가 아닌 값은 예외가 발생한다.")
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

    @Test
    void checkLessThanMaxAmount() {
    }

    @Test
    void checkEmptySpace() {
    }

    @Test
    void checkThousandUnits() {
    }
}