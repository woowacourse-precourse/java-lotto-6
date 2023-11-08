package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;
import lotto.view.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameManagerTest extends NsTest {
    GameManager gameManager = new GameManager();

    @Test
    @DisplayName("구매금액만큼 로또를 발행하는 테스트")
    void createLotto_test() {
        assertThat(gameManager.createLotto(8000).size()).isEqualTo(8);
    }

    @Test
    @DisplayName("로또 번호를 당첨 번호, 보너스 번호와 비교하여 당첨 통계를 변경하는 테스트")
    void compareTotalLotto_test() {
        List<Lotto> totalLottoTest = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        List<Integer> winningNumbersTest = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumberTest = 7;
        WinningStatistics winningStatisticsTest = new WinningStatistics();

        gameManager.compareTotalLotto(totalLottoTest, winningNumbersTest, bonusNumberTest, winningStatisticsTest);
        Output.printWinningResult(winningStatisticsTest);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @Override
    protected void runMain() {
    }
}
