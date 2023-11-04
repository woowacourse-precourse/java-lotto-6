package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.util.StringUtil;
import org.junit.jupiter.api.Test;

public class StringUtilTest {
    @Test
    void testStringSplitWithComma() {
        assertEquals(List.of("1", "2", "3"), StringUtil.splitWithComma("1,2,3"));
    }

    @Test
    void testStringtoInt() {
        assertEquals(1, StringUtil.convertStringToInt("1"));
    }

    @Test
    void testListToString() {
        assertEquals("1, 2, 3", StringUtil.convertListToString(List.of(1,2,3)));
    }
}
