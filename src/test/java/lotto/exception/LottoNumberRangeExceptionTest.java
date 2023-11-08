package lotto.exception;

import org.junit.jupiter.api.Test;


class LottoNumberRangeExceptionTest {
    @Test
    public void testNumberRangeException_ValidNumber() {

        int validNumber = 42;


        LottoNumberRangeException.NumberRangeException(validNumber);


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