package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.controller.validator.WinningNumberValidator;
import lotto.utils.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumberValidatorTest {
    private WinningNumberValidator winningNumberValidator;

    @BeforeEach
    void setUp() {
        winningNumberValidator = new WinningNumberValidator();
    }

    @Test
    void testValidWinningNumbers() {
        String validNumbers = "1,2,3,4,5,6";
        assertThatCode(() -> winningNumberValidator.validate(validNumbers)).doesNotThrowAnyException();
    }


    @Test
    void testInvalidNumberCount() {
        // Test cases for invalid winning numbers
        String invalidNumbers1 = "1,2,3,4,5";  // Less than 6 numbers
        String invalidNumbers2 = "1,2,3,4,5,7,8";  // More than 6 numbers

        assertThatThrownBy(() -> winningNumberValidator.validate(invalidNumbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.INVALID_LOTTO_NUMBER_COUNT_EXCEPTION);

        assertThatThrownBy(() -> winningNumberValidator.validate(invalidNumbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.INVALID_LOTTO_NUMBER_COUNT_EXCEPTION);
    }

    @Test
    void testNonNumericWinningNumber() {
        String invalidNumbers3 = "1,2,3,4,5,A";  // Contains non-numeric character

        assertThatThrownBy(() -> winningNumberValidator.validate(invalidNumbers3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.NON_NUMERIC_EXCEPTION_MESSAGE);
    }

    @Test
    void testOutOfRangeWinningNumbers() {
        // Test cases for out of range winning numbers
        String outOfRangeNumbers1 = "0,2,3,4,5,6";  // Contains number below MIN_LOTTO_NUMBER
        String outOfRangeNumbers2 = "1,2,3,4,5,50";  // Contains number above MAX_LOTTO_NUMBER

        assertThatThrownBy(() -> winningNumberValidator.validate(outOfRangeNumbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.OUT_OF_RANGE_EXCEPTION_MESSAGE);

        assertThatThrownBy(() -> winningNumberValidator.validate(outOfRangeNumbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.OUT_OF_RANGE_EXCEPTION_MESSAGE);
    }

    @Test
    void testDuplicatedWinningNumbers() {
        // Test case for duplicated winning numbers
        String duplicatedNumbers = "1,2,2,4,5,6";

        assertThatThrownBy(() -> winningNumberValidator.validate(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
    }
}