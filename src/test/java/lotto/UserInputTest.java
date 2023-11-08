package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    public UserInput input = new UserInput();

    @DisplayName("구입 금액이 1000원으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void isNotDivisibleBy1000_whenAmountIsDivisibleBy1000_shouldReturnTrue() {
        boolean result = input.isNotDivisibleBy1000(3000);
        assertTrue(result);
    }

    @Test
    void isNotDivisibleBy1000_whenAmountIsNotDivisibleBy1000_shouldReturnFalse() {
        boolean result = input.isNotDivisibleBy1000(2500);
        assertFalse(result);
    }}