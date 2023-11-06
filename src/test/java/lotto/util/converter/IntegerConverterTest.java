package lotto.util.converter;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IntegerConverterTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "12", "012"})
    void 문자에서_숫자로_변환한다 (String value) {
        assertDoesNotThrow(() -> IntegerConverter.convert(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a12"})
    void 문자에서_숫자로_변환을_실패한다 (String value) {
        assertThatThrownBy(() -> IntegerConverter.convert(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 정수만 입력 가능합니다.");
    }
}