package lotto.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    private static WinningStatistics winningStatistics = new WinningStatistics();

    @BeforeAll
    static void initialize() {
        List<Lotto> purchaseLottos = new ArrayList<>() {{
            add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
            add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
            add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
            add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
            add(new Lotto(List.of(1, 2, 8, 9, 10, 11)));
        }};
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        winningStatistics.setWinningResult(purchaseLottos, winningLotto, bonusNumber);
    }

    @DisplayName("구입 로또, 당첨 로또, 보너스 번호가 주어졌을 때, 당첨 결과가 제대로 초기화 되는지 확인")
    @Test
    void setWinningResult() {
        Map<WinningPrize, Integer> expectedResult = new LinkedHashMap<>() {{
            put(WinningPrize.FIFTH_PRIZE, 1);
            put(WinningPrize.FOURTH_PRIZE, 1);
            put(WinningPrize.THIRD_PRIZE, 1);
            put(WinningPrize.SECOND_PRIZE, 1);
            put(WinningPrize.FIRST_PRIZE, 1);
        }};
        assertThat(winningStatistics.getWinningResult()).isEqualTo(expectedResult);
    }

    @DisplayName("구입 금액이 주어졌을 때, 총 수익률이 제대로 초기화 되는지 확인")
    @Test
    void setRateOfReturn() {
        winningStatistics.setRateOfReturn(6000);
        assertThat(winningStatistics.getRateOfReturn()).isEqualTo(33859250);
    }
}
