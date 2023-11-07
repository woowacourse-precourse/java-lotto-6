package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerTest {

    LottoChecker lottoChecker;

    @BeforeEach
    void setUp() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        lottoChecker = new LottoChecker(winningLotto, bonus);
    }

    @Test
    @DisplayName("로또의 당첨 결과를 확인한다.")
    void checkWinningResult() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto1, lotto2, lotto3));

        Map<Rank, Integer> winningResult = lottoChecker.checkWinningResult(lottoTickets);

        assertThat(winningResult).containsEntry(Rank.ONE, 1);
        assertThat(winningResult).containsEntry(Rank.TWO, 1);
        assertThat(winningResult).containsEntry(Rank.THREE, 1);
    }
}
