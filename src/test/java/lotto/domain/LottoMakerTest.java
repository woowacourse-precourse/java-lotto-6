package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMakerTest {
    LottoMaker seller = new LottoMaker(5000);

    @DisplayName("필요한 개수만큼 올바른 로또를 발행하는지 검수")
    @Test
    void makeLottoTickets() {
        assertDoesNotThrow(() -> {
            List<Lotto> tickets = seller.makeLottoTickets();
            assertThat(tickets.size()).isEqualTo(5);
        });
    }
}