package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    Parser parser = new Parser();
    @Test
    @DisplayName("입력한 금액에 단위표시가 있을 때 테스트")
    public void testParserInputWithComma(){
        String input = "1,000";
        int expected = 1000;
        int result = parser.lottoPrice(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("정상적으로 입력했을 때 테스트")
    public void testParserValidInput() {
        String input = "1000";
        int expected = 1000;
        int result = parser.lottoPrice(input);
        assertEquals(expected, result);
    }



}
