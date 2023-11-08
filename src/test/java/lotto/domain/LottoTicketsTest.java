package lotto.domain;

import lotto.dto.PurchaseResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {


    private final PurchaseResult purchaseResult = new PurchaseResult(
            List.of(List.of(1,2,3,4,5,6),
                    List.of(5,6,7,8,9,10),
                    List.of(11,12,13,14,15,16)
            )
    );


    @Test
    @DisplayName("구매한 로또 티켓을 가져온다.")
    void getTickets() {
        // Given
        LottoTickets lottoTickets = LottoTickets.create(purchaseResult);

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