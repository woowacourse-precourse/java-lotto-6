package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class LottoGameTest {
    @Test
    public void testGenerateLottoNumbers() {
        LottoGame lottoGame = new LottoGame();
        int expectedTicketCount = 4;
        int actualTicketCount = lottoGame.generateLottoNumbers(expectedTicketCount).size();
        assertEquals(expectedTicketCount, actualTicketCount);
    }
}