package lotto.util.converter;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MultipleNumericConverterTest {
    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4")
    void 문자에서_숫자로_변환한다 (String value) {
        assertDoesNotThrow(() -> MultipleNumericConverter.convert(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1,2,3", "a1,2,3"})
    void 문자에서_숫자로_변환을_실패한다 (String value) {
        assertThatThrownBy(() -> MultipleNumericConverter.convert(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 정수만 입력 가능합니다.");
    }
}