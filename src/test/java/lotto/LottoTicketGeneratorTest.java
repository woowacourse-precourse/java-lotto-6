package lotto;

import java.util.List;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoTicketGenerator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LottoTicketGeneratorTest {

    @Test
    public void testGenerateLottoTicket() {
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoTicketGenerator ticketGenerator = LottoTicketGenerator.create(numberGenerator);
        List<List<Integer>> lottoTicket = ticketGenerator.generateLottoTicket(8000);

        assertNotNull(lottoTicket);
        assertEquals(8, lottoTicket.size());
        for (List<Integer> numberInTicket : lottoTicket) {
            assertEquals(6, numberInTicket.size());
        }
    }
}
