package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {
    private static final String NUMBER_OUT_OF_RANGE = "[ERROR] 1에서 45사이의 숫자를 입력해주세요.";

    @DisplayName("")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createNumberByOutOfRange(int number) {
        assertThatThrownBy(
                () -> Number.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void createNumberByWithinRange(int number) {
        assertThatCode(
                () -> Number.from(number))
                .doesNotThrowAnyException();
    }
}
