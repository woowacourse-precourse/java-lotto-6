package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringParserTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "100:100"}, delimiter = ':')
    void parsePurchaseAmount_양의_정수(String input, Integer expected) {
        Integer parsed = StringParser.parsePurchaseAmount(input);

        assertThat(parsed).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "-11", "0", "00", "dk124", "..."})
    void parsePurchaseAmount_양의_정수가_아닌_문자열(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parsePurchaseAmount(input);
        });
    }
}