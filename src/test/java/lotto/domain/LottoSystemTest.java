package lotto.domain;

import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoSystemTest {

    @DisplayName("수익률 계산 확인")
    @Test
    void calculateRateOfReturn() {
        LottoSystem lottoSystem = new LottoSystem(8000);

        Map<WinningResult, Integer> map = new HashMap<>();
        map.put(WinningResult.FIFTH, 1);

        assertThat(lottoSystem.calculateRateOfReturn(map)).isEqualTo(62.5f);
    }

    @DisplayName("1등 당첨 결과 개수 확인")
    @Test
    void compareWinningLotto1() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7);

        Map<WinningResult, Integer> map = new HashMap<>();
        map.put(WinningResult.FIRST, 1);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoSystem lottoSystem = new LottoSystem(1000);
                    assertThat(lottoSystem.compareWinningLotto(winningLotto)).isEqualTo(map);
                },
                List.of(1,2,3,4,5,6)
        );
    }

    @DisplayName("2등 당첨 결과 개수 확인")
    @Test
    void compareWinningLotto2() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7);

        Map<WinningResult, Integer> map = new HashMap<>();
        map.put(WinningResult.SECOND, 2);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoSystem lottoSystem = new LottoSystem(2000);
                    assertThat(lottoSystem.compareWinningLotto(winningLotto)).isEqualTo(map);
                },
                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,5,7)
        );
    }
}
