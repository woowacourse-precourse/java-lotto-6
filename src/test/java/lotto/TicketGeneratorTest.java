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
        List<Lotto> lottoTickets = ticketGenerator.generateLottoTicket(8000);

        assertNotNull(lottoTickets);
        assertEquals(8, lottoTickets.size());
    }
}
