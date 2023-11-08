package lotto.Test.FunctionTest;

import lotto.model.lottoGenerator.LottoTicketCreator;
import lotto.model.lottoGenerator.LottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTicketCreatorTest {

    private static class StubLottoNumberGenerator extends LottoNumberGenerator {
        @Override
        public List<Integer> generateNumbers() {
            return IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());
        }
    }

    private LottoTicketCreator ticketCreator;

    @BeforeEach
    void setUp() {
        LottoNumberGenerator stubNumberGenerator = new StubLottoNumberGenerator();
        ticketCreator = new LottoTicketCreator(stubNumberGenerator);
    }

    @Test
    @DisplayName("요청된 티켓 수만큼 로또 티켓을 생성해야 한다")
    void shouldCreateRequestedNumberOfLottoTickets() {
        int numberOfTickets = 5;
        List<List<Integer>> tickets = ticketCreator.createLottoTickets(numberOfTickets);
        assertEquals(numberOfTickets, tickets.size(), "생성된 티켓의 수가 요청과 일치하지 않습니다.");
    }

    @Test
    @DisplayName("각 로또 티켓은 6개의 번호를 가져야 한다")
    void eachLottoTicketShouldHaveSixNumbers() {
        List<List<Integer>> tickets = ticketCreator.createLottoTickets(1);
        assertEquals(6, tickets.get(0).size(), "티켓은 6개의 번호를 가져야 합니다.");
    }
}
