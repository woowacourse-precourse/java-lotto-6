package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketsTest {

    @DisplayName("로또 티켓 리스트 생성 테스트")
    @Test
    void createLottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(10000);
        assertThat(lottoTickets.getTickets().size()).isEqualTo(10);
    }

    @DisplayName("로또 티켓 리스트 사이즈 생성 테스트")
    @Test
    void createLottoTicketsSize() {
        LottoTickets lottoTickets = new LottoTickets(10000);
        assertThat(lottoTickets.getTickets().get(0).getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 티켓 카운트 테스트")
    @Test
    void createLottoTicketsCount() {
        LottoTickets lottoTickets = new LottoTickets(10000);
        assertThat(lottoTickets.getTicketCount()).isEqualTo(10);
    }
}
