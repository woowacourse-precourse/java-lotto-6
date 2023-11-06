package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    private UserInput userInput;

    @BeforeEach
     void setUp() {
        userInput = new UserInput();
    }
    @Test
    void 숫자_입력_확인() {
        assertThrows(IllegalArgumentException.class, () -> userInput.checkInt("abc"));
    }

    @Test
    void 구입금액_확인() {
        assertThrows(IllegalArgumentException.class, () -> userInput.checkPurchaseAmount(10010));
    }
}