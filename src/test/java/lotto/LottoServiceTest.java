package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("정상적으로 발행된 티켓")
    @Test
    void generateLottoTickets_CorrectNumberOfTickets() {

        int purchaseAmount = 5000;

        lottoService.generateLottoTickets(purchaseAmount);
        List<Lotto> generatedTickets = lottoService.getLottoTickets();


        int expectedTicketCount = purchaseAmount / 1000;
        assertThat(generatedTickets).hasSize(expectedTicketCount);


        for (Lotto ticket : generatedTickets) {
            assertThat(ticket.getNumbers()).hasSize(6);
            assertThat(ticket.getNumbers()).isSorted();
            assertThat(ticket.getNumbers()).doesNotHaveDuplicates();
            assertThat(ticket.getNumbers())
                    .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
        }
    }


}
