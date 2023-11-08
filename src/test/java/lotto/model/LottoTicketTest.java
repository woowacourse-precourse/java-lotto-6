package lotto.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("일치하는 번호에 따라 등수가 맞는지 확인")
    @Test
    void equalRank() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 13, 24, 35, 36));
        Bonus bonus = new Bonus(10, winningLotto);
        List<Lotto> ticketLottoIsOne = List.of(new Lotto(List.of(1, 2, 13, 24, 35, 10)));

        LottoTicket lottoTicketTest = new LottoTicket(ticketLottoIsOne);

        WinStatistics result = lottoTicketTest.getRank(winningLotto, bonus);
        WinStatistics expect = new WinStatistics();
        expect.pushRank(Rank.SECOND);

        assertThat(result).isEqualTo(expect);
    }
}
