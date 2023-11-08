package lotto.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputUtilTest {

    @DisplayName("StringToInt 타입 변환 테스트")
    @Test
    public void stringToIntTest() {
        // given
        String number = "5";
        // when
        int result = InputUtil.toIntStringNumberParser(number);
        // then
        Assertions.assertEquals(5, result);
    }
}
