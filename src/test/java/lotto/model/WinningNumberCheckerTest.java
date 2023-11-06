package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberCheckerTest {
    private WinningNumberChecker winningNumberChecker;
    private Lottos lottos;

    @BeforeEach
    void init() {
        lottos = new Lottos();
    }

    @Test
    @DisplayName("1등일 경우를 올바르게 체크할 수 있는지")
    void checkRank1st() {
        lottos.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        winningNumberChecker = new WinningNumberChecker(List.of(1,2,3,4,5,6),7,lottos);
        assertThat(winningNumberChecker.getWinningRankResult().get("1st")).isEqualTo(1);
    }

    @Test
    @DisplayName("2등일 경우를 올바르게 체크할 수 있는지")
    void checkRank2nd() {
        lottos.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        winningNumberChecker = new WinningNumberChecker(List.of(1,2,3,4,5,8),6,lottos);
        assertThat(winningNumberChecker.getWinningRankResult().get("2nd")).isEqualTo(1);
    }

    @Test
    @DisplayName("3등일 경우를 올바르게 체크할 수 있는지")
    void checkRank3rd() {
        lottos.addLotto(new Lotto(List.of(1,2,3,4,5,7)));
        winningNumberChecker = new WinningNumberChecker(List.of(1,2,3,4,5,8),9,lottos);
        assertThat(winningNumberChecker.getWinningRankResult().get("3rd")).isEqualTo(1);
    }

    @Test
    @DisplayName("4등일 경우를 올바르게 체크할 수 있는지")
    void checkRank4th() {
        lottos.addLotto(new Lotto(List.of(1,2,3,4,5,7)));
        winningNumberChecker = new WinningNumberChecker(List.of(1,2,3,4,45,44),43,lottos);
        assertThat(winningNumberChecker.getWinningRankResult().get("4th")).isEqualTo(1);
    }

    @Test
    @DisplayName("5등일 경우를 올바르게 체크할 수 있는지")
    void checkRank5th() {
        lottos.addLotto(new Lotto(List.of(1,2,3,4,5,7)));
        winningNumberChecker = new WinningNumberChecker(List.of(1,2,3,45,44,43),7,lottos);
        assertThat(winningNumberChecker.getWinningRankResult().get("5th")).isEqualTo(1);
    }
}
