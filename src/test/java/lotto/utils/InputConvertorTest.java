package lotto.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputConvertorTest {

    @ParameterizedTest
    @CsvSource(value = {"'8000', 8000", "'4000', 4000", "'100', 100"})
    void convertMoney는_문자열을_정수로_변환한다(String input, int output) {
        // when
        int result = InputConvertor.convertMoney(input);
        // then
        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"'8,000', 8000", "'4,000', 4000", "'10,000', 10000"})
    void convertMoney는_쉼표있는_문자열은_정수로_변환한다(String input, int output) {
        // when
        int result = InputConvertor.convertMoney(input);
        // then
        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @ValueSource(strings = {"8s000", "'4000s", " "})
    void convertMoney는_정수가아닌_문자열에_예외를_반환한다(String input) {
        assertThatThrownBy(() -> InputConvertor.convertMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "100000000"})
    void convertMoney는_최소_최대범위를_벗어난_문자열에_예외를_반환한다(String input) {
        assertThatThrownBy(() -> InputConvertor.convertMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}