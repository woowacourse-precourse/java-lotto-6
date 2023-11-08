package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyInputViewTest {
    @Test
    void testZeroInput() {
        // given
        String input = "000";
        // when
        int result = Integer.parseInt(input);
        // then
        assertEquals(0, result);
    }
}