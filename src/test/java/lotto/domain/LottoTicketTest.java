package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @DisplayName("로또 티켓을 생성하면 로또 번호가 저장된다.")
    @Test
    void getLotto() {
        LottoTicket ticket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        assertThat(ticket.getLotto().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
