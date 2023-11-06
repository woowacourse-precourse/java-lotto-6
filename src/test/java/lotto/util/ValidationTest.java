package lotto.util;

import static lotto.constants.ErrorMessage.*;
import static lotto.util.Validation.validateBonusNumDuplicated;
import static lotto.util.Validation.validateComma;
import static lotto.util.Validation.validateDivisibleByLottoPrice;
import static lotto.util.Validation.validateDuplicatedSixNumber;
import static lotto.util.Validation.validateInteger;
import static lotto.util.Validation.validateNumberRange;
import static lotto.util.Validation.validatePositiveNumber;
import static lotto.util.Validation.validateSixLottoNumbers;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {

    @ParameterizedTest
    @DisplayName("문자열이 정수로 변환 가능하지 않으면 에러 메시지 출력")
    @ValueSource(strings = {"5000a", "5_000", " 5000 ", "5000.0", "5,000"})
    void validateInteger_test(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validateInteger(input));
        assertEquals(String.format(ERROR_FORMAT+NOT_INTEGER+input), exception.getMessage());
        assertThatCode(() -> validateInteger("5000")).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("변환된 정수가 양의 정수가 아니면 에러 메시지 출력")
    @ValueSource(ints = {-1000, 0})
    void validatePositiveNumber_test(int input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validatePositiveNumber(input));
        assertEquals(String.format(ERROR_FORMAT+NOT_POSITIVE+input), exception.getMessage());
        assertThatCode(() -> validatePositiveNumber(1000)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("변환된 양의 정수가 1000원으로 나누어떨어지지 않으면 에러 메시지 출력")
    @ValueSource(ints = {7777, 7770, 7700})
    void validateDivisibleByLottoPrice_test(int input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validateDivisibleByLottoPrice(input));
        assertEquals(String.format(ERROR_FORMAT+INDIVISIBLE_TO_THOUSAND+input), exception.getMessage());
        assertThatCode(() -> validateDivisibleByLottoPrice(7000)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("쉼표(,)가 입력된 문자열의 처음 또는 마지막에 오거나 연속으로 사용되면 에러 메시지 출력")
    @ValueSource(strings = {",1,2,3,4,5,6", "1,2,3,4,5,6,", "1,,2,3,4,5,6", "1,2,,3,4,,5,6"})
    void validateComma_test(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validateComma(input));
        assertEquals(String.format(ERROR_FORMAT+INVALID_COMMA+input), exception.getMessage());
        assertThatCode(() -> validateComma("1,2,3,4,5,6")).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("입력받은 로또 번호 또는 보너스 번호가 1~45 사이 숫자가 아니면 에러 메시지 출력")
    @ValueSource(ints = {0, 46})
    void validateNumberRange_exceptionTest(int input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validateNumberRange(input));
        assertEquals(String.format(ERROR_FORMAT+INVALID_NUMBER+input), exception.getMessage());
        assertThatCode(() -> validateNumberRange(1)).doesNotThrowAnyException();
        assertThatCode(() -> validateNumberRange(45)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 6개가 아니면 에러 메시지 출력")
    @MethodSource("sampleLottoNumbers")
    void validateSixLottoNumbers_test(List<Integer> input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validateSixLottoNumbers(input));
        assertEquals(String.format(ERROR_FORMAT+NOT_SIX_NUMBERS), exception.getMessage());
        assertThatCode(() -> validateSixLottoNumbers(List.of(1,2,3,4,5,6))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("6개의 로또 번호 중 서로 중복된 숫자가 존재하면 에러 메시지 출력")
    void validateDuplicatedSixNumber_test() {
        List<Integer> input = List.of(1,5,2,3,5,4);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validateDuplicatedSixNumber(input));
        assertEquals(String.format(ERROR_FORMAT+DUPLICATED_NUMBER), exception.getMessage());
        assertThatCode(() -> validateDuplicatedSixNumber(List.of(1,2,3,4,5,6))).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 6개의 당첨 번호 중 한 개와 중복되면 에러메시지 출력")
    @MethodSource("sampleBonusNumAndLottoNum")
    void validateBonusNumDuplicated_test(int bonusInput, List<Integer> lottoInput) {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> validateBonusNumDuplicated(bonusInput, lottoInput)
        );
        assertEquals(String.format(ERROR_FORMAT+DUPLICATED_NUMBER), exception.getMessage());
        assertThatCode(() -> validateBonusNumDuplicated(23, List.of(1,3,5,7,9,11))).doesNotThrowAnyException();
    }

    private static Stream<Arguments> sampleLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5)),
                Arguments.of(List.of(1,2,3,4,5,6,7))
        );
    }
    private static Stream<Arguments> sampleBonusNumAndLottoNum() {
        return Stream.of(
                Arguments.of(1, List.of(1,2,3,4,5,6)),
                Arguments.of(45, List.of(8,27,45,16,39,20))
        );
    }
}