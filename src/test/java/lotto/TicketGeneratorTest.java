package lotto;

import java.util.List;
import lotto.service.NumberGenerator;
import lotto.service.TicketGenerator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicketGeneratorTest {

    @Test
    public void testGenerateLottoTicket() {
        NumberGenerator numberGenerator = new NumberGenerator();
        TicketGenerator ticketGenerator = TicketGenerator.create(numberGenerator);
        List<List<Integer>> lottoTicket = ticketGenerator.generateLottoTicket(8000);

        assertNotNull(lottoTicket);
        assertEquals(8, lottoTicket.size());
        for (List<Integer> numberInTicket : lottoTicket) {
            assertEquals(6, numberInTicket.size());
        }
    }
}
