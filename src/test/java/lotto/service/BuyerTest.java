package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {
    private Buyer buyer;

    @BeforeEach
    void setUp() {
        //싱글톤
        buyer = Buyer.getInstance();
        //테스트 독립
        buyer.getLottoTickets().clear();
    }

    @Test
    @DisplayName("구매 금액에 따른 올바른 로또 티켓 개수 테스트")
    void calculateLottoTicketsShouldReturnCorrectCount() {
        // Given
        PurchaseAmount purchaseAmount = new PurchaseAmount("5000");

        // When
        int ticketCount = Buyer.calculateLottoTickets(purchaseAmount);

        // Then
        assertThat(ticketCount).isEqualTo(5);
    }

    @Test
    @DisplayName("티켓 개수에 따라 올바르게 추가해주는지 테스트")
    void buyLottoTicketsShouldAddCorrectNumberOfTickets() {
        // Given
        int lottoTicketCount = 5;

        // When
        buyer.buyLottoTickets(lottoTicketCount);

        // Then
        List<Lotto> tickets = buyer.getLottoTickets();
        assertThat(tickets).hasSize(lottoTicketCount);
        for (Lotto ticket : tickets) {
            assertThat(ticket.getNumbers()).hasSize(6);
            assertThat(ticket.getNumbers()).doesNotHaveDuplicates();
            assertThat(ticket.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
        }
    }
}
