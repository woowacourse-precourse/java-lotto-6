package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParserTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "10, 10", "-10, -10"})
    void 문자를_숫자로_변경한다(String input, int result) {
        Assertions.assertThat(Parser.parseToInteger(input)).isEqualTo(result);
    }
}
