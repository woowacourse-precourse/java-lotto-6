package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberGeneratorTest {

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @CsvSource({"한글", "English", "1000j"})
    @ParameterizedTest
    void inputNotNumber(String input) {
        assertThatThrownBy(() -> NumberGenerator.formatNumber(input)).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("입력값이 없으면 예외가 발생한다.")
    @Test
    void inputNothing() {
        assertThatThrownBy(() -> NumberGenerator.formatNumber(null)).isInstanceOf(NullPointerException.class);
    }
}