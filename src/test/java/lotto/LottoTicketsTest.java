package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 티켓들의 올바른 순위를 반환한다.")
    void calculateRanking() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numbers);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);

        LottoTicket lottoTicket = new LottoTicket(lotto);
        LottoTickets lottoTickets = new LottoTickets(List.of(lottoTicket));

        List<Ranking> rankings = lottoTickets.calculateRanking(winningLotto);

        Assertions.assertEquals(
                rankings.get(0), Ranking.SIX_MATCH
        );
    }

}
