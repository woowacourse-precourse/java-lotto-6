package lotto.domain;

import lotto.util.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoBonusNumberTest {
    @Test
    public void validTest() {
        assertDoesNotThrow(() -> new LottoBonusNumber("1"));
    }

    @Test
    public void typeTest() {
        assertThrows(IllegalArgumentException.class, () -> new LottoBonusNumber("String"));
    }

    @Test
    public void rangeTest() {
        assertThrows(IllegalArgumentException.class, () -> new LottoBonusNumber("50"));
    }

    @Test
    public void setLottoBonusNumberLoopTest() {
        Status status = Status.FAIL;
        int attempt = 0;

        while (status == Status.FAIL) {
            try {
                new LottoBonusNumber("fail");
                status = Status.SUCCESS;
            } catch (IllegalArgumentException ignored) {
            } finally {
                attempt++;
            }
            if (attempt == 3) {
                break;
            }
        }
        assertEquals(attempt, 3);
    }
}