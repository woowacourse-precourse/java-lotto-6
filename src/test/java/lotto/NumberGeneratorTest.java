package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberGeneratorTest {

    @CsvSource({"한글", "English", "1000j"})
    @ParameterizedTest
    void 숫자_이외의_입력_예외처리(String input) {
        assertThatThrownBy(() -> NumberGenerator.formatNumber(input)).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 입력값이_없을_때_예외처리() {
        assertThatThrownBy(() -> NumberGenerator.formatNumber(null)).isInstanceOf(IllegalArgumentException.class);
    }
}