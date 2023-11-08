package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.utils.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumberCheckerTest {
    private WinningNumberChecker winningNumberChecker;
    private Lottos lottos;

    @BeforeEach
    void init() {
        lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @CsvSource({"FIRST,1", "SECOND,0", "THIRD,0", "FOURTH,0", "FIFTH,0"})
    @DisplayName("1등일 경우를 올바르게 체크할 수 있는지")
    void checkRank1st(Rank rank, int result) {
        winningNumberChecker = new WinningNumberChecker(List.of(1, 2, 3, 4, 5, 6), 7, lottos);
        winningNumberChecker.checkWinningRankResult();
        assertThat(winningNumberChecker.getWinningRankResult().get(rank)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"FIRST,0", "SECOND,1", "THIRD,0", "FOURTH,0", "FIFTH,0"})
    @DisplayName("2등일 경우를 올바르게 체크할 수 있는지")
    void checkRank2nd(Rank rank, int result) {
        winningNumberChecker = new WinningNumberChecker(List.of(1, 2, 3, 4, 5, 8), 6, lottos);
        winningNumberChecker.checkWinningRankResult();
        assertThat(winningNumberChecker.getWinningRankResult().get(rank)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"FIRST,0", "SECOND,0", "THIRD,1", "FOURTH,0", "FIFTH,0"})
    @DisplayName("3등일 경우를 올바르게 체크할 수 있는지")
    void checkRank3rd(Rank rank, int result) {
        winningNumberChecker = new WinningNumberChecker(List.of(1, 2, 3, 4, 5, 8), 9, lottos);
        winningNumberChecker.checkWinningRankResult();
        assertThat(winningNumberChecker.getWinningRankResult().get(rank)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"FIRST,0", "SECOND,0", "THIRD,0", "FOURTH,1", "FIFTH,0"})
    @DisplayName("4등일 경우를 올바르게 체크할 수 있는지")
    void checkRank4th(Rank rank, int result) {
        winningNumberChecker = new WinningNumberChecker(List.of(1, 2, 3, 4, 45, 44), 43, lottos);
        winningNumberChecker.checkWinningRankResult();
        assertThat(winningNumberChecker.getWinningRankResult().get(rank)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"FIRST,0", "SECOND,0", "THIRD,0", "FOURTH,0", "FIFTH,1"})
    @DisplayName("5등일 경우를 올바르게 체크할 수 있는지")
    void checkRank5th(Rank rank, int result) {
        winningNumberChecker = new WinningNumberChecker(List.of(1, 2, 3, 45, 44, 43), 7, lottos);
        winningNumberChecker.checkWinningRankResult();
        assertThat(winningNumberChecker.getWinningRankResult().get(rank)).isEqualTo(result);
    }
}
