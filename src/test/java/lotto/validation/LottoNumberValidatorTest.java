package lotto.validation;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoNumberValidatorTest {

    @ParameterizedTest
    @DisplayName("당첨번호 입력테스트")
    @CsvSource({"' '", "''", "'1,2,3,'", "',1,2,3'", "'1,,2,3'", "'ㄱ,1,3'", "'-1,2,3'", "' 1,2,3'", "'1, 2,3'"})
    void validateWinningNumberReadLineTest(String readLine) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.validateWinningNumberReadLine(readLine))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @MethodSource("validateLottoNumberTestValue")
    @DisplayName("당첨번호 검증 테스트")
    void validateLottoNumberTest(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> validateLottoNumberTestValue() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 3, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(0, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }
}
