package lotto.validation;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.IncludeCharException;
import lotto.exception.InvalidSeparatorException;
import lotto.exception.NumberDuplicateException;
import lotto.exception.NumberRangeException;
import lotto.exception.NumbersSizeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoNumberValidatorTest {

    @ParameterizedTest
    @DisplayName("로또 번호 정상입력 테스트")
    @CsvSource({"'1,2,3,4,5,6'", "'45,44,43,42,41,40'", "'25,26,27,28,29,30'"})
    void validateCostReadLineTest(String readLine) {
        Assertions.assertThatCode(() -> LottoNumberValidator.validateWinningNumberReadLine(readLine))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("validateLottoNumberTestValue")
    @DisplayName("로또 번호 정상형식 테스트")
    void validateLottoNumberTest(List<Integer> numbers) {
        Assertions.assertThatCode(() -> LottoNumberValidator.validateLottoNumber(numbers))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> validateLottoNumberTestValue() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(30, 41, 42, 43, 44, 45))
        );
    }


    @ParameterizedTest
    @DisplayName("[ERROR] 구분자를 잘못 사용하였을때")
    @CsvSource({"'1,2,3,'", "',1,2,3'", "'1,,2,3'"})
    void validateSeparateTest(String readLine) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.validateWinningNumberReadLine(readLine))
                .isInstanceOf(InvalidSeparatorException.class);

    }

    @ParameterizedTest
    @DisplayName("[ERROR] 글자가 포함되어 있을때")
    @CsvSource({"'1,2, 나'", "'가,2,3'", "'1,나,3'", "' 1,2,3'", "'1, 2,3'"})
    void validateContainCharTest(String readLine) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.validateWinningNumberReadLine(readLine))
                .isInstanceOf(IncludeCharException.class);

    }

    @ParameterizedTest
    @MethodSource("checkLengthTestValue")
    @DisplayName("[ERROR] 당첨번호 갯수가 6개가 아닐때")
    void checkLengthTest(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumber(numbers))
                .isInstanceOf(NumbersSizeException.class);
    }

    private static Stream<Arguments> checkLengthTestValue() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 3, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(2, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("checkDuplicateTestValue")
    @DisplayName("[ERROR] 당첨번호에 중복이 존재할때")
    void checkDuplicateTest(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumber(numbers))
                .isInstanceOf(NumberDuplicateException.class);
    }

    private static Stream<Arguments> checkDuplicateTestValue() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 3, 5, 6)),
                Arguments.of(List.of(1, 1, 1, 1, 1, 1)),
                Arguments.of(List.of(1, 1, 1, 1, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("checkNumberInRangeTestValue")
    @DisplayName("[ERROR] 당첨번호가 유효한 범위안에 있는지")
    void checkNumberInRangeTest(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumber(numbers))
                .isInstanceOf(NumberRangeException.class);
    }

    private static Stream<Arguments> checkNumberInRangeTestValue() {
        return Stream.of(
                Arguments.of(List.of(-1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 56)),
                Arguments.of(List.of(57, 78, 96, 12, 5, 6))
        );
    }
}
