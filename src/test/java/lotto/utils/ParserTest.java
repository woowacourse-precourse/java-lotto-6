package lotto.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ParserTest {
    @DisplayName("구매 갯수 계산 테스트")
    @Test
    public void testParsePaymentToCoin() {
        int payment = 5000;
        int coins = Parser.parsePaymentToCoin(payment);
        assertEquals(5, coins);
    }
}
