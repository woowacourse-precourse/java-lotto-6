package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.Player;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest extends NsTest {

    @DisplayName("로또 당첨 통계를 낸다.")
    @Test
    void createWinningStatistics() {

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoService lottoService = new LottoService();
                    Player player = new Player(1000);
                    WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

                    Map<Rank, Integer> winningStatistics = lottoService.makeWinningStatistics(player, winningLotto);

                    Map<Rank, Integer> expectedWinningStatistics = new TreeMap<>();
                    expectedWinningStatistics.put(Rank.FIFTH, 0);
                    expectedWinningStatistics.put(Rank.FOURTH, 0);
                    expectedWinningStatistics.put(Rank.THIRD, 0);
                    expectedWinningStatistics.put(Rank.SECOND, 1);
                    expectedWinningStatistics.put(Rank.FIRST, 0);

                    assertThat(winningStatistics).isEqualTo(expectedWinningStatistics);
                },
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
