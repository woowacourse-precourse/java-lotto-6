package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    @DisplayName("각 로또별 당첨 순위를 구한다.")
    void test() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto1, lotto2, lotto3));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);

        //when
        Map<Lotto, Rank> rankByLotto = lottoTickets.findRankByLotto(winningLotto, bonus);

        //then
        assertThat(rankByLotto).containsEntry(lotto1, Rank.ONE);
        assertThat(rankByLotto).containsEntry(lotto2, Rank.TWO);
        assertThat(rankByLotto).containsEntry(lotto3, Rank.THREE);
    }
}
