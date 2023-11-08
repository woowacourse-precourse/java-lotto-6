package lotto.io;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ErrorHandlerTest {
    @Test
    void checkInt() {
        assertThrows(IllegalArgumentException.class, () -> ErrorHandler.checkInt("1000j"));
    }

    @Test
    void checkPositive() {
        assertThrows(IllegalArgumentException.class, () -> ErrorHandler.checkPositive("-100"));
    }

    @Test
    void checkThousands() {
        assertThrows(IllegalArgumentException.class, () -> ErrorHandler.checkThousands("1001"));
    }

    @Test
    void validateRepeat() {
        assertThrows(IllegalArgumentException.class, () -> ErrorHandler.validateRepeat(List.of(1, 2, 3, 4, 5, 6, 6)));
    }

    @Test
    void validateRange() {
        assertThrows(IllegalArgumentException.class, () -> ErrorHandler.validateRange(List.of(1, 2, 3, 4, 5, 6, 56)));
    }

    @Test
    void checkSize() {
        assertThrows(IllegalArgumentException.class,
                () -> ErrorHandler.checkSize(List.of("1", "2", "3", "4", "5", "6")));
    }
}