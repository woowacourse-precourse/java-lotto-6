package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberRangeExceptionTest {
    @Test
    public void testNumberRangeException_ValidNumber() {
        // Arrange
        int validNumber = 42;

        // Act
        LottoNumberRangeException.NumberRangeException(validNumber);

        // No exception is thrown, the test passes
    }

    @Test
    public void testNumberRangeException_OutOfRange() {
        // Arrange
        int outOfRangeNumber = 50;

        // Act
        LottoNumberRangeException.NumberRangeException(outOfRangeNumber);
    }

    @Test
    public void testNumberRangeException_NegativeNumber() {
        // Arrange
        int negativeNumber = -5;

        // Act
        LottoNumberRangeException.NumberRangeException(negativeNumber);
    }
}