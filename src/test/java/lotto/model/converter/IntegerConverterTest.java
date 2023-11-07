package lotto.model.converter;

import static lotto.util.ExceptionMessage.INVALID_TYPE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class IntegerConverterTest {
    IntegerConverter integerConverter;

    @BeforeEach
    void beforeEach() {
        integerConverter = new IntegerConverter();
    }

    @ParameterizedTest
    @MethodSource("convertedGoodToNumbers")
    @DisplayName("입력 리스트의 문자들이 숫자일 경우 어떠한 Exceptoin도 감지되지 않는다.")
    void listSuccessTest(List<String> inputs) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> integerConverter.toTypeList(inputs));
    }

    static Stream<List> convertedGoodToNumbers() {
        return Stream.of(
                Arrays.asList("1", "2", "3", "4", "5", "6"),
                Arrays.asList("45", "45", "45", "45", "45", "45")
        );
    }

    @ParameterizedTest
    @MethodSource("convertedBadToNumbers")
    @DisplayName("입력 리스트의 문자들이 Integer가 아닐 경우 IllegalArgumentException을 반환한다.")
    void notIntegerNumbersTest(List<String> inputs) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> integerConverter.toTypeList(inputs))
                .withMessage(INVALID_TYPE.getMessage());
    }

    static Stream<List> convertedBadToNumbers() {
        return Stream.of(
                Arrays.asList("1", ".", "3", "4", "5", "6"),
                Arrays.asList("2147483648", "1", "2", "3", "4", "5"),
                Arrays.asList("1", "", "3", "4", "5", "6")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1"})
    @DisplayName("입력 문자가 Integer일 경우 어떠한 Exception도 감지되지 않는다.")
    void integerSuccessTest(String input) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> integerConverter.toType(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {".", "", " ", "2147483648"})
    @DisplayName("입력 문자가 Integer가 아닐 경우 IllegalArgumentException을 반환한다.")
    void integerFailTest(String input) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> integerConverter.toType(input))
                .withMessage(INVALID_TYPE.getMessage());
    }
}