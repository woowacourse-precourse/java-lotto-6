package lotto.Util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {

    @Test
    @DisplayName("문자열을 정수로 변환하는 로직에 대한 테스트")
    public void ConvertStringToIntegerTest() throws Exception {
        //given
        String str = "1";

        //when
        Integer result = Util.convertStringToInteger(str);

        //then
        assertEquals(1, result);
    }

}