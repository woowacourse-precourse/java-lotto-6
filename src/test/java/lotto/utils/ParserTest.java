package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class ParserTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "10, 10", "-10, -10"})
    void 문자를_숫자로_변경한다(String input, int result) {
        Assertions.assertThat(Parser.parseToInteger(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1, 2, 3, 4, 5"})
    void 문자를_숫자_리스트로_변경한다(String input) {
        //when
        List<Integer> output = Parser.parseToIntegers(input);
        //then
        Assertions.assertThat(output).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void 문자를_리스트로_변경한다() {
        //given
        String input = "한, 글, 1, 2, 3";
        //when
        List<String> output = Parser.parseToStrings(input);
        //then
        Assertions.assertThat(output).containsExactly("한", "글", "1", "2", "3");
    }

}
