package lotto.util;

import static lotto.util.message.Error.MUST_INTEGER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConversionTest {

    @ParameterizedTest
    @CsvSource(value = {"abcd", "ABCD", "1234A", "123!", "1 23", " ", " 12 "},
            ignoreLeadingAndTrailingWhitespace = false)
    @DisplayName("숫자가 아니면 예외가 발생한다.")
    public void stringToIntTest(String input) {
        Assertions.assertThatThrownBy(() -> Conversion.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MUST_INTEGER.getError());
    }

    @DisplayName("구분자가 쉼표(,)가 아니거나, 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1.2.3.4.5.6", "1/2/3/4/5/6", "1-2-3-4-5-6", "a,b,c,d,e,f"}, delimiter = '|')
    public void stringToListTest(String input) {
        Assertions.assertThatThrownBy(() -> Conversion.stringToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MUST_INTEGER.getError());
    }
}