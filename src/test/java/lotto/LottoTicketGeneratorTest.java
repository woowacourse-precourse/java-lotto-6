package lotto;

import java.util.List;
import lotto.service.LottoTicketGenerator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LottoTicketGeneratorTest {

    @Test
    public void testGenerateLottoTicket() {
        LottoTicketGenerator generator = new LottoTicketGenerator();
        List<List<Integer>> lottoTicket = generator.generateLottoTicket(8000);

        assertNotNull(lottoTicket);
        assertEquals(8, lottoTicket.size());
        for (List<Integer> numberInTicket : lottoTicket) {
            assertEquals(6, numberInTicket.size());
        }
    }
}
