package lotto.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class StringUtilTest {

    @Test
    @DisplayName("문자열을 정수 리스트로 변환하는지 테스트")
    void convertToIntegerList() {
        String input = "1, 2, 3, 4, 5";
        String delimiter = ", ";

        List<Integer> result = StringUtil.convertToIntegerList(input, delimiter);

        assertEquals(5, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(3, result.get(2));
        assertEquals(4, result.get(3));
        assertEquals(5, result.get(4));
    }
}
