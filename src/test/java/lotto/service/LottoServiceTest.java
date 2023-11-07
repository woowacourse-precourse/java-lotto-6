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

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class LottoServiceTest extends NsTest {

    @DisplayName("정렬된 로또 당첨 통계를 낸다.")
    @Test
    void createWinningStatistics() {

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoService lottoService = new LottoService();
                    Player player = new Player(1000);
                    WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

                    Map<Rank, Integer> winningStatistics = lottoService.makeWinningStatistics(player, winningLotto);

                    assertThat(winningStatistics).containsExactly(
                            entry(Rank.FIFTH, 0),
                            entry(Rank.FOURTH, 0),
                            entry(Rank.THIRD, 0),
                            entry(Rank.SECOND, 1),
                            entry(Rank.FIRST, 0)
                    );
                },
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
