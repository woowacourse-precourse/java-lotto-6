package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputCheckerTest {
    private UserInputChecker userInputChecker;

    @BeforeEach
    void sutUp() {
        userInputChecker = new UserInputChecker();
    }

    @Test
    void 구입금액_확인() {
        assertThrows(IllegalArgumentException.class, () -> userInputChecker.checkInputUnit(10010));
    }
}