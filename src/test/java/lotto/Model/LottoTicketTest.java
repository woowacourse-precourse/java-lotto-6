package lotto.Model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTicketTest {

    @Test
    public void testLottoTicketCreation() {
        int numberOfLottos = 5;
        LottoTicket ticket = new LottoTicket(numberOfLottos);
        List<Lotto> lottos = ticket.getLottos();

        assertEquals(numberOfLottos, lottos.size());
        for (Lotto lotto : lottos) {
            assertEquals(6, lotto.getNumbers().size());
            assertTrue(lotto.getNumbers().stream().allMatch(n -> n >= 1 && n <= 45));
        }
    }
}
