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
    @DisplayName("내가 생성한 만큼만 생성되어야 한다")
    void lottoTicketHasCorrectNumberOfEntries() {
        Assertions.assertEquals(numberOfTickets, lottoTicket.getLottoEntries().size());
    }

    @Test
    @DisplayName("중복이 있으면 안된다")
    void lottoTicketContainsUniqueEntries() {
        Set<Lotto> uniqueEntries = new HashSet<>(lottoTicket.getLottoEntries());
        Assertions.assertEquals(numberOfTickets, uniqueEntries.size());
    }

    @Test
    @DisplayName("LottoTicket는 적절하게 toString을 수행해야 한다")
    void toStringReturnsCorrectlyFormattedString() {
        String stringRepresentation = lottoTicket.toString();
        Assertions.assertNotNull(stringRepresentation);
    }

}
