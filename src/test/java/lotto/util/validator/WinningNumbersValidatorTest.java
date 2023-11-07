package lotto.util.validator;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumbersValidatorTest {

    private final WinningNumbersValidator validator = new WinningNumbersValidator();

    private static Stream<Arguments> validNumbersProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(10, 20, 30, 40, 11, 22)),
                Arguments.of(List.of(41, 42, 43, 44, 45, 1))
        );
    }

    private static Stream<Arguments> duplicatedNumbersProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 3, 5, 6)),
                Arguments.of(List.of(10, 10, 20, 30, 40, 50))
        );
    }

    private static Stream<Arguments> numbersOutOfRangeProvider() {
        return Stream.of(
                Arguments.of(List.of(0, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 49))
        );
    }

    private static Stream<Arguments> incorrectSizeNumbersProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("validNumbersProvider")
    @DisplayName("리스트가 올바른 6개의 유니크한 숫자를 포함하고 있으면 예외를 발생시키지 않는다.")
    void testValidateValidList(List<Integer> numbers) {
        Assertions.assertDoesNotThrow(() -> validator.validate(numbers));
    }

    @ParameterizedTest
    @MethodSource("duplicatedNumbersProvider")
    @DisplayName("리스트가 중복된 숫자를 포함하고 있으면 예외를 발생시킨다.")
    void testValidateDuplicatedNumbers(List<Integer> numbers) {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> validator.validate(numbers));
        Assertions.assertEquals(ErrorMessage.WINNING_NUMBERS_IS_DUPLICATED, exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("numbersOutOfRangeProvider")
    @DisplayName("리스트가 범위를 벗어난 숫자를 포함하고 있으면 예외를 발생시킨다.")
    void testValidateNumbersOutOfRange(List<Integer> numbers) {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> validator.validate(numbers));
        Assertions.assertEquals(ErrorMessage.WINNING_NUMBERS_IS_NOT_VALID_RANGE, exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("incorrectSizeNumbersProvider")
    @DisplayName("리스트의 크기가 6이 아니면 예외를 발생시킨다.")
    void testValidateIncorrectSize(List<Integer> numbers) {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> validator.validate(numbers));
        Assertions.assertEquals(ErrorMessage.WINNING_NUMBERS_SIZE_IS_SMALL, exception.getMessage());
    }
}
