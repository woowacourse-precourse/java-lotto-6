package lotto;

import static lotto.model.Prize.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PlayerLottos;
import lotto.model.Prize;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

    private final List<Lotto> playerLottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(3, 4, 5, 6, 7, 8))
    );

    private final WinningLotto winningLotto = new WinningLotto(
            new Lotto(List.of(3, 4, 5, 6, 8, 10)),
            new BonusNumber("7")
    );

    @DisplayName("통계 저장 확인 테스트")
    @Test
    void testRightStatistic() {
        Statistics statistics = new Statistics(new PlayerLottos(playerLottos), winningLotto);
        Map<Prize, Integer> result = statistics.getResult();

        assertThat(result.get(FIFTH))
                .isEqualTo(0);
        assertThat(result.get(FOURTH))
                .isEqualTo(1);
        assertThat(result.get(THIRD))
                .isEqualTo(0);
        assertThat(result.get(SECOND))
                .isEqualTo(1);
        assertThat(result.get(FIRST))
                .isEqualTo(0);
    }
}
