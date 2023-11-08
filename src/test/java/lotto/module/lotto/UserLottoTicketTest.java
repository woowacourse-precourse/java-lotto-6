package lotto.module.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserLottoTicketTest {

    @Test
    void 유저_로또_티켓_생성_성공_테스트() {
        // given
        List<Lotto> purchaseTickets = new ArrayList<>();
        purchaseTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        UserLottoTickets userLottoTicket = UserLottoTickets.newInstance(purchaseTickets);

        // when
        List<Lotto> tickets = userLottoTicket.tickets();

        // then
        Assertions.assertThat(tickets.size())
                .isEqualTo(1);
    }

}