package lotto.console;

import lotto.constant.ConsoleMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;

class OutputConsoleTest {
    @DisplayName("둘째 자리에서 반올림 테스트")
    @ParameterizedTest
    @CsvSource(value = {"12.345:12.3", "123.456:123.5", "123.45:123.5", "10:10.0"}, delimiter = ':')
    void roundDecimalFormatTest(double value, String expected) {
        // given
        DecimalFormat df = ConsoleMessage.decimalFormat;

        // when
        String result = df.format(value);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("천 이상의 숫자인 경우 ',' 구분자로 구분하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"123456.789:123,456.8", "1000000:1,000,000.0"}, delimiter = ':')
    void delimiterDecimalFormatTest(double value, String expected) {
        // given
        DecimalFormat df = ConsoleMessage.decimalFormat;

        // when
        String result = df.format(value);

        // then
        assertThat(result).isEqualTo(expected);
    }
}