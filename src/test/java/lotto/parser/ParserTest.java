package lotto.parser;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import org.assertj.core.api.Assertions;

public class ParserTest {
    @Test
    void testGetRateOfReturn() {
        int earnMoney = 5000;
        int money = 2000;
        double rateOfReturn = Parser.getRateOfReturn(earnMoney, money);
        Assertions.assertThat(rateOfReturn).isEqualTo(250);
    }

    @Test
    void testParseIntArray() {
        String input = "1,4,5,6,8,9";
        int[] result = Parser.parseIntArray(input);
        Assertions.assertThat(result[0] + result[1]).isEqualTo(5);
    }

    @Test
    void testSplitString() {
        String input = "1,4,5,6,8,9";
        String[] result = Parser.splitString(input);
        Assertions.assertThat(Arrays.toString(result)).isEqualTo("[1, 4, 5, 6, 8, 9]");
    }
}
