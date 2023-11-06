package lotto.io;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ErrorHandlerTest {
    ErrorHandler errorHandler = new ErrorHandler();

    @Test
    void checkInt() {
        assertThrows(IllegalArgumentException.class, () -> errorHandler.checkInt("string"));
    }

    @Test
    void checkPositive() {
        assertThrows(IllegalArgumentException.class, () -> errorHandler.checkPositive("-100"));
    }

    @Test
    void checkThousands() {
        assertThrows(IllegalArgumentException.class, () -> errorHandler.checkThousands("1001"));
    }
    @Test
    void validateRepeat() {
        assertThrows(IllegalArgumentException.class, () -> errorHandler.validateRepeat(List.of(1,2,3,4,5,6,6)));
    }@Test
    void validateRange() {
        assertThrows(IllegalArgumentException.class, () -> errorHandler.validateRange(List.of(1,2,3,4,5,6,56)));
    }

}