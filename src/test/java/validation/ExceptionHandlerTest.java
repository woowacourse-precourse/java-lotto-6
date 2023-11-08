package validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionHandlerTest {

    private final ExceptionHandler exceptionHandler;

    public ExceptionHandlerTest(){
        exceptionHandler = new ExceptionHandler();
    }
    @Test
    @DisplayName("구매 가격 입력 시 숫자 이외의 것이 입력되면 예외 발생")
    void validateIfOnlyNumber() {
        String number = "1000?";
        assertThrows(NumberFormatException.class, () -> {
            exceptionHandler.validateIfOnlyNumber(number);
        });
    }

    @Test
    void validateBonusNumber() {
    }

    @Test
    void validateNumberOrComma() {
    }

    @Test
    void validateMultipleOfThousand() {
    }

    @Test
    void validateWinningNumber() {
    }
}