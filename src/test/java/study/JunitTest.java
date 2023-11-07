package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class JunitTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "   1,2,3   ", "1,2,3 ", "  1,2,3"})
    @DisplayName("ValueSource 는 문자열 그대로 반환")
    void valueSource(String input) {
        System.out.println(input);
        System.out.println(input.length());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6", "1,12,2,3,4,5", "1,2,3,4,5,6", "   1,2,3,4,5,6"})
    @DisplayName("CsvSource 기본 구분자는 콤마다. 주의!")
    void csvSourceComma(String input)  {
        System.out.println(input);
        System.out.println(input.length());
        assertThat(input).isEqualTo("1");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "    1,2,3", "   1,2,3   "},
            delimiter = ':')
    @DisplayName("CsvSource 는 trim() 한다.")
    void csvSourceString(String input) {
        System.out.println(input);
        System.out.println(input.length());
        assertThat(input).isEqualTo("1,2,3");
    }

    @ParameterizedTest
    @CsvSource(value = {" 1, 2,   3", "  1, 2,   3 "},
            delimiter = ':')
    @DisplayName("CsvSource 중간 공백인 경우는 그대로 있다")
    void csvSourceStringTrim(String input) {
        System.out.println(input);
        System.out.println(input.length());
        assertThat(input).isEqualTo("1, 2,   3");
    }
}
