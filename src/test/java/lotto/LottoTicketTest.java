package lotto;

import java.util.HashSet;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    private LottoTicket lottoTicket;
    private final int numberOfTickets = 5;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(numberOfTickets);
    }

    @Test
    void 생성한_숫자만큼만_생성되어야한다() {
        Assertions.assertEquals(numberOfTickets, lottoTicket.getLottoEntries().size());
    }

    @Test
    void 중복_없어야한다() {
        Set<Lotto> uniqueEntries = new HashSet<>(lottoTicket.getLottoEntries());
        Assertions.assertEquals(numberOfTickets, uniqueEntries.size());
    }

    @Test
    void toString_정상동작() {
        String stringRepresentation = lottoTicket.toString();
        Assertions.assertNotNull(stringRepresentation);
    }

}
