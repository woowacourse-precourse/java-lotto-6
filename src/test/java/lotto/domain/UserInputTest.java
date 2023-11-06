package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    private UserInput userInput;
    private UserInputChecker userInputChecker;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
        userInputChecker = new UserInputChecker();
    }

    @Test
    void 구입금액이_1000원_단위가_아닌_상황_예외처리() {
        assertEquals(0, userInput.getUserPurchaseAmount(userInputChecker, "10010"));
    }

    @Test
    void 숫자가_아닌_구입금액_예외처리() {
        assertEquals(0, userInput.getUserPurchaseAmount(userInputChecker, "abc"));
    }

    @Test
    void 중복된_당첨번호_예외처리() {
        assertEquals(null, userInput.getUserWinningNumbers(userInputChecker, "1,2,3,4,5,5"));
    }

    @Test
    void 숫자가_아닌_당첨번호_입력_예외처리() {
        assertEquals(null, userInput.getUserWinningNumbers(userInputChecker, "1,2,3,4,5,a"));
    }

    @Test
    void 잘못된_범위의_당첨번호_입력_예외처리() {
        assertEquals(null, userInput.getUserWinningNumbers(userInputChecker, "1,2,3,4,5,46"));
    }
}