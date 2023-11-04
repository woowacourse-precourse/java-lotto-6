package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    @DisplayName("구입한 복권들과 당첨 번호를 비교하여 당첨 통계를 계산하는 테스트. 통계가 예상과 틀리면 테스트에 실패한다.")
    @Test
    void calculateWinningStatisticsTest() {
        // given
        WinningStatistics winningStatistics = getWinningStatistics();
        Map<LottoPrize, Integer> expected = new HashMap<>() {{
            put(LottoPrize.FIRST, 1);   // 1등 1개
            put(LottoPrize.SECOND, 0);   // 2등 0개
            put(LottoPrize.THIRD, 1);   // 3등 1개
            put(LottoPrize.FOURTH, 1);   // 4등 1개
            put(LottoPrize.FIFTH, 3);   // 5등 3개
            put(LottoPrize.NOTHING, 2);   // 꽝 2개
        }};

        // when
        Map<LottoPrize, Integer> prizeCounter = winningStatistics.getPrizeCounter();

        // then
        assertThat(prizeCounter).isEqualTo(expected);
    }

    private static WinningStatistics getWinningStatistics() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        List<Lotto> purchased = new ArrayList<>() {{
            add(new Lotto(List.of(2, 3, 4, 5, 6, 1))); // 1등 복권
            add(new Lotto(List.of(14, 15, 16, 17, 18, 19)));    // 꽝
            add(new Lotto(List.of(2, 3, 4, 5, 6, 10))); // 3등 복권
            add(new Lotto(List.of(2, 3, 4, 5, 10, 11))); // 4등 복권
            add(new Lotto(List.of(2, 3, 4, 10, 11, 12))); // 5등 복권
            add(new Lotto(List.of(9, 3, 4, 5, 11, 12))); // 5등 복권
            add(new Lotto(List.of(10, 3, 4, 5, 11, 12))); // 5등 복권
            add(new Lotto(List.of(12, 13, 14, 15, 16, 17)));    // 꽝
        }};
        return new WinningStatistics(winningLotto, purchased);
    }
}
