package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("빈값 입력 예외 테스트")
    @ValueSource(strings = {"", " ", "  ", "   "})
    void invalidInputsTest1(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isEmpty(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_VALUE);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 입력 예외 테스트")
    @ValueSource(strings = {"1a", "abd21", "45.2", "뮹2", ",g"})
    void invalidInputsTest2(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_NUMERIC);
    }

    @ParameterizedTest
    @DisplayName("1,000원 단위가 아닌 입력 예외 테스트")
    @ValueSource(strings = {"1001", "999", "100", "1100", "100001"})
    void invalidInputsTest3(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isThousandUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_THOUSAND_UNIT);
    }


    @ParameterizedTest
    @DisplayName("로또 금액 입력 유효성 성공 테스트")
    @ValueSource(strings = {"1000", "10000", "5000"})
    void validInputsTest1(String input) {
        Assertions.assertThatCode(() -> Validator.isValidPurchaseAmount(input))
                .doesNotThrowAnyException();
    }


    @ParameterizedTest
    @DisplayName("구분자를 잘못 입력 예외 테스트")
    @ValueSource(strings = {"1,2,,,3,4,5,6", ",1,2,3,4,5,6", "1,2,3,4,5,6,", "1,,2,3,4,5,6"})
    void invalidInputsTest4(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isValidCommaSeparator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.SEPARATOR_CHECK);
    }

    private static Stream<Arguments> provideDuplicateWinNumberTestCases() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "1", "3", "4", "5", "6"}),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "6", "6"}),
                Arguments.of((Object) new String[]{"1", "2", "2", "2", "6", "12"})
        );
    }

    @ParameterizedTest
    @DisplayName("중복된 당첨 숫자를 입력한 경우 예외 테스트")
    @MethodSource("provideDuplicateWinNumberTestCases")
    void invalidInputsTest5(String[] input) {
        Assertions.assertThatThrownBy(() -> Validator.isDuplicateWinNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_NON_DUPLICATE_WIN_NUMBER);
    }

    @ParameterizedTest
    @DisplayName("숫자 범위 1~45사이가 아닌 입력 예외 테스트")
    @ValueSource(strings = {"0", "999", "46", "-1"})
    void invalidInputsTest6(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isNumberInRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_NUMBER_IN_RANGE);
    }

    private static Stream<Arguments> provideSixItemsTestCases() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6", "7"}),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5"}),
                Arguments.of((Object) new String[]{"1"})
        );
    }

    @ParameterizedTest
    @DisplayName("구분된 번호가 6개가 아닌 경우 예외 테스트")
    @MethodSource("provideSixItemsTestCases")
    void invalidInputsTest7(String[] input) {
        Assertions.assertThatThrownBy(() -> Validator.isSixItems(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_SIX_ITEMS);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호를 입력 유효성 성공 테스트")
    @ValueSource(strings = {"1,2,3,4,5,6", "8,21,23,41,42,43", "13,14,16,38,42,45"})
    void validInputsTest2(String input) {
        Assertions.assertThatCode(() -> Validator.isValidWinningNumbers(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("보너스 번호를 입력 유효성 성공 테스트")
    @ValueSource(strings = {"1", "7"})
    void validInputsTest3(String input) {
        Assertions.assertThatCode(() -> Validator.isValidBonusNumber(input))
                .doesNotThrowAnyException();
    }
}