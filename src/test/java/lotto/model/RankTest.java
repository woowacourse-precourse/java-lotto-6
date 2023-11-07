package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 몇 등인지 확인한다.")
    void getRankByLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 7), 6);
        Rank rankByLotto = Rank.getRankByLotto(lotto, winningLotto);
        assertEquals(Rank.SECOND, rankByLotto);
    }
}