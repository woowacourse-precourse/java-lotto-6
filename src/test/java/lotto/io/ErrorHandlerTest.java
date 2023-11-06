package lotto.io;

import static org.junit.jupiter.api.Assertions.*;

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
}