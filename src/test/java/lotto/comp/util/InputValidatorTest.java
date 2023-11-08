package lotto.comp.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.InputValidator;


class InputValidatorTest {

    @DisplayName("입력한 문자열이 숫자인지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "40"})
    void validNumberType(String inputValue) {
        assertDoesNotThrow(() -> {
            InputValidator.validNumberType(inputValue);
        });
    }

    @DisplayName("[예외]입력한 문자열이 숫자인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"001", "ㄴㅇㄹ"})
    @NullSource
    @EmptySource
    void validNumberType_exception(String inputValue) {
        assertThatThrownBy(() -> {
            InputValidator.validNumberType(inputValue);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 리스트의 사이즈가 정해진 시이즈인지 확인")
    @ParameterizedTest
    @MethodSource("dataForValidListSize")
    void validListSize(List<Integer> input, int size, boolean expected) {
        assertThat(InputValidator.isValidListSize(input, size))
                .isEqualTo(expected);
    }

    static Stream<Arguments> dataForValidListSize() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6, true),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 5, false)
        );
    }

    @DisplayName("리스트에 중복값이 없는지 확인")
    @ParameterizedTest
    @MethodSource("dataForDuplicate")
    void hasDuplicateNum(List<Integer> input, boolean expected) {
        assertThat(InputValidator.hasDuplicateNum(input))
                .isEqualTo(expected);
    }

    static Stream<Arguments> dataForDuplicate() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), false),
                Arguments.of(Arrays.asList(1, 2, 3, 3, 5, 6), true)
        );
    }

    @DisplayName("숫자 범위가 맞는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "0:false", "45:true", "46:false"}, delimiter = ':')
    void isValidRange(int input, boolean expected) {
        assertThat(InputValidator.isValidRangeNum(input, 1, 45))
                .isEqualTo(expected);
    }


    @DisplayName("나누어 떨어지는 확인")
    @ParameterizedTest
    @CsvSource(value = {"14000:true", "8000:true", "10010:false", "1001:false", "1:false"}, delimiter = ':')
    void isDivisible(int input, boolean expected) {
        assertThat(InputValidator.isDivisible(input, 1000))
                .isEqualTo(expected);
    }


}
