package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.DecimalFormat;

public class DecimalFormatTest {

    @ParameterizedTest
    @CsvSource(value = {"1327: 1,327","2000000: 2,000,000", "1200000000: 1,200,000,000"},delimiter = ':')
    void 세자리_마다_컴마를_잘_찍는_테스트(float input, String expected){
        DecimalFormat formatter = new DecimalFormat("###,###,##0.#");
        Assertions.assertThat(formatter.format(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0.1234: 0.1234", "0.12345678: 0.12345678"},delimiter = ':')
    void 소숫점은_컴마를_안_찍는지_테스트(float input, String expected){
        DecimalFormat formatter = new DecimalFormat("###,###.########");
        Assertions.assertThat(formatter.format(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0: 0.0","1234.56: 1,234.6","456.394:456.4"},delimiter = ':')
    void 반올림하여_소수_첫쨰자리까지_나타내는지_테스트(float input, String expected){
        DecimalFormat formatter = new DecimalFormat("###,###,##0.0");
        Assertions.assertThat(formatter.format(input)).isEqualTo(expected);
    }
}
