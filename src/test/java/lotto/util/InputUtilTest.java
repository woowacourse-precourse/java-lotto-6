package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputUtilTest {

    @Test
    @DisplayName("정상적인 숫자가 들어왔을 때, int 값으로 반환을 한다.")
    void testParseIntWithValidInput() {
        // given
        String input = "123";

        // when
        int result = InputUtil.parseInt(input);

        // then
        assertEquals(123, result);
    }


}