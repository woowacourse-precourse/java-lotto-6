package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void testFirstRank() {
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7); // 보너스 번호는 어떤 것이든 될 수 있음
        Rank rank = Rank.determineRank(ticket, winningLotto);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void testSecondRank() {
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);
        Rank rank = Rank.determineRank(ticket, winningLotto);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void testThirdRank() {
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);
        Rank rank = Rank.determineRank(ticket, winningLotto);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void testFifthRank() {
        Lotto ticket = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);
        Rank rank = Rank.determineRank(ticket, winningLotto);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void testNoneRank() {
        Lotto ticket = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);
        Rank rank = Rank.determineRank(ticket, winningLotto);
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
