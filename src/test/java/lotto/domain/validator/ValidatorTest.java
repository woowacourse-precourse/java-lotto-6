package lotto.domain.validator;

import lotto.constant.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    private static List<List<Integer>> provideListsForTestingHaveDuplicateNumber() {
        return Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 5),
                Arrays.asList(4, 5, 6, 6, 7, 7),
                Arrays.asList(7, 8, 8, 9, 9, 6)
        );
    }

    private static List<List<Integer>> provideListsForTestingHaveSixNumbers() {
        return Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 5),
                Arrays.asList(4, 5, 6, 6, 7, 7),
                Arrays.asList(7, 8, 8, 9, 9, 6)
        );
    }

    private static List<List<Integer>> provideListsForTestingNotHaveSixNumbers() {
        return Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 5, 2),
                Arrays.asList(4, 5, 6, 6, 7)
        );
    }

    static Stream<Arguments> stringArraysProvider() {
        // 테스트 데이터를 제공하는 데이터 소스 메서드
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3"}),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5"}),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6", "7"})
        );
    }

    @DisplayName("공백이나 빈값이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void validateExistValue(String whiteSpace) {
        assertThatThrownBy(() -> Validator.validateExistValue(whiteSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NON_EXISTENT_VALUE);
    }

    @DisplayName("맨 앞자리가 0으로 시작하거나 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "원", "1000d"})
    void validateNumericInput(String notNumber) {
        assertThatThrownBy(() -> Validator.validateNumericInput(notNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_NUMERIC_VALUE);
    }

    @DisplayName("1000으로 나눠지지 않는 숫자가 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 21, 132, 1001, 20002})
    void validateDivisibleBy1000(int indivisible) {
        assertThatThrownBy(() -> Validator.validateDivisibleBy1000(indivisible))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INDIVISIBLE_BY_1000);
    }

    @DisplayName("중복 숫자가 존재하면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideListsForTestingHaveDuplicateNumber")
    void validateDuplicateNumbers(List<Integer> testList) {
        assertThatThrownBy(() -> Validator.validateDuplicateNumbers(testList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_HAS_DUPLICATE_NUMBERS);
    }

    @DisplayName("쉼표 전후에 아무런 값이 없으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,,,3,4,5,6", ",,1,2,3,4,5,6", "1,2,3,4,5,6,", "1, , 2, 3, 4, 5, 6"})
    void hasCommasWithoutSurroundingValues(String valuesSeparatedByCommas) {
        assertThatThrownBy(() -> Validator.hasCommasWithoutSurroundingValues(valuesSeparatedByCommas))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_CONTAIN_CONSECUTIVE_COMMAS);
    }

    @DisplayName("올바른 값이 들어왔을 때 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6", "1, 2, 3 , 4, 5, 6"})
    void hasCommasWithoutSurroundingValues2(String valuesSeparatedByCommas) {
        assertThatCode(() -> Validator.hasCommasWithoutSurroundingValues(valuesSeparatedByCommas))
                .doesNotThrowAnyException();
    }

    @DisplayName("6개로 이루어진 값이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("stringArraysProvider")
    void validateCountOfValues(String[] splitValues) {
        assertThatThrownBy(() -> Validator.validateCountOfValues(splitValues))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_COUNT_OF_VALUES);
    }

    @DisplayName("1~45 에 해당하는 숫자 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {46, 471, 192, 2023, 2022})
    void validateNumberInRange(int testNum) {
        assertThatThrownBy(() -> Validator.validateNumberInRange(testNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_OUT_OF_RANGES);
    }

    @DisplayName("6개로 이루어진 숫자 리스트가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideListsForTestingNotHaveSixNumbers")
    void validateCountOfNumbers1(List<Integer> testList) {
        assertThatThrownBy(() -> Validator.validateCountOfNumbers(testList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_COUNT_OF_VALUES);
    }

    @DisplayName("6개로 이루어진 숫자 리스트면 아니면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @MethodSource("provideListsForTestingHaveSixNumbers")
    void validateCountOfNumbers2(List<Integer> testList) {
        assertThatCode(() -> Validator.validateCountOfNumbers(testList))
                .doesNotThrowAnyException();
    }
}