package lotto.domain;

import lotto.dto.PurchaseResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {


    private final PurchaseResult purchaseResult1 = new PurchaseResult(List.of(1,2,3,4,5,6));
    private final PurchaseResult purchaseResult2 = new PurchaseResult(List.of(5,6,7,8,9,10));
    private final PurchaseResult purchaseResult3 = new PurchaseResult(List.of(11,12,13,14,15,16));

    @Test
    @DisplayName("구매한 로또 티켓을 가져온다.")
    void getTickets() {
        // Given
        LottoTickets lottoTickets = LottoTickets.create(List.of(purchaseResult1, purchaseResult2, purchaseResult3));

        // When
        List<Lotto> tickets = lottoTickets.getTickets();

        // Then
        assertThat(tickets).isNotNull();
        assertThat(tickets).hasSize(3);

        assertThat(tickets.get(0).getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(tickets.get(1).getNumbers()).isEqualTo(List.of(5,6,7,8,9,10));
        assertThat(tickets.get(2).getNumbers()).isEqualTo(List.of(11,12,13,14,15,16));
    }
}