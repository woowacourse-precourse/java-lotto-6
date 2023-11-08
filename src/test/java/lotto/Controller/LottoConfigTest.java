package lotto.Controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoConfigTest {

    @Test
    public void testLottoConfigValues() {
        assertEquals(1, LottoConfig.NUMBER_RANGE_START.getValue());
        assertEquals(45, LottoConfig.NUMBER_RANGE_END.getValue());
        assertEquals(6, LottoConfig.NUMBERS_PER_TICKET.getValue());
    }
}
