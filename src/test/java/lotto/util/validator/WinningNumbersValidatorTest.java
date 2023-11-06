package lotto.util.validator;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningNumbersValidatorTest {

    private WinningNumbersValidator validator;

    @BeforeEach
    void setUp() {
        validator = new WinningNumbersValidator();
    }

    @Test
    @DisplayName("리스트가 올바른 6개의 유니크한 숫자를 포함하고 있으면 예외를 발생시키지 않는다.")
    void testValidateValidList() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        validator.validate(numbers);
    }

    @Test
    @DisplayName("리스트가 중복된 숫자를 포함하고 있으면 예외를 발생시킨다.")
    void testValidateDuplicatedNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 3, 5, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(numbers));
        Assertions.assertEquals(ErrorMessage.WINNING_NUMBERS_IS_DUPLICATED, exception.getMessage());
    }

    @Test
    @DisplayName("리스트가 범위를 벗어난 숫자를 포함하고 있으면 예외를 발생시킨다.")
    void testValidateNumbersOutOfRange() {
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 49);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(numbers));
        Assertions.assertEquals(ErrorMessage.WINNING_NUMBERS_IS_NOT_VALID_RANGE, exception.getMessage());
    }

    @Test
    @DisplayName("리스트의 크기가 6이 아니면 예외를 발생시킨다.")
    void testValidateIncorrectSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(numbers));
        Assertions.assertEquals(ErrorMessage.WINNING_NUMBERS_SIZE_IS_SMALL, exception.getMessage());
    }
}
