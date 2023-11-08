package lotto.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PrizeTest {

    @Test
    public void testValueOf() {
        assertEquals(Prize.MATCH_3, Prize.valueOf(3, false));
        assertEquals(Prize.MATCH_4, Prize.valueOf(4, false));
        assertEquals(Prize.MATCH_5, Prize.valueOf(5, false));
        assertEquals(Prize.MATCH_5_BONUS, Prize.valueOf(5, true));
        assertEquals(Prize.MATCH_6, Prize.valueOf(6, false));
        assertNull(Prize.valueOf(2, false));
    }
}
