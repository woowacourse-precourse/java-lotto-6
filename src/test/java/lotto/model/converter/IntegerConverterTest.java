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

class IntegerConverterTest {
    IntegerConverter integerConverter;

    @BeforeEach
    void beforeEach() {
        integerConverter = new IntegerConverter();
    }

    @ParameterizedTest
    @MethodSource("convertedGoodToNumber")
    @DisplayName("입력 문자가 숫자일 경우 어떠한 Exceptoin도 감지되지 않는다.")
    void successTest(List<String> inputs) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> integerConverter.toTypeList(inputs));
    }

    static Stream<List> convertedGoodToNumber() {
        return Stream.of(
                Arrays.asList("1", "2", "3", "4", "5", "6"),
                Arrays.asList("45", "45", "45", "45", "45", "45")
        );
    }

    @ParameterizedTest
    @MethodSource("convertedBadToNumber")
    @DisplayName("입력 문자가 Integer가 아닐 경우 IllegalArgumentException을 반환한다.")
    void notIntegerNumberTest(List<String> inputs) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> integerConverter.toTypeList(inputs))
                .withMessage(INVALID_TYPE.getMessage());
    }

    static Stream<List> convertedBadToNumber() {
        return Stream.of(
                Arrays.asList("1", ".", "3", "4", "5", "6"),
                Arrays.asList("2147483648", "1", "2", "3", "4", "5"),
                Arrays.asList("1", "", "3", "4", "5", "6")
        );
    }
}