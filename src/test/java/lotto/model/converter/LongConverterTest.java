package lotto.model.converter;

import static lotto.util.ExceptionMessage.INVALID_LONG_TYPE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LongConverterTest {
    LongConverter longConverter;

    @BeforeEach
    void beforeEach() {
        longConverter = new LongConverter();
    }

    @ParameterizedTest
    @ValueSource(strings = {"9223372036854775807"})
    @DisplayName("Long 범위 내의 숫자일 경우 어떠한 에러도 반환하지 않는다.")
    void successTest(String input) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> longConverter.toType(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123abc"})
    @DisplayName("숫자가 아닐 경우 IllegalArgumentException이 반환된다.")
    void notNumberFailTest(String input) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> longConverter.toType(input))
                .withMessage(INVALID_LONG_TYPE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"9223372036854775808"})
    @DisplayName("long 범위를 벗어나는 경우 IllegalArgumentException이 반환된다.")
    void biggerThanLongMaxFailTest(String input) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> longConverter.toType(input))
                .withMessage(INVALID_LONG_TYPE.getMessage());
    }
}