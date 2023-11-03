package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningStatistics 클래스")
class WinningStatisticsTest {

    @DisplayName("TotalProfitRate 계산 테스트")
    @Test
    void testCalculateTotalProfitRate() {
        // given
        WinningResult winningResult = createSampleWinningResult();

        // when
        WinningStatistics winningStatistics = new WinningStatistics(winningResult);
        double totalProfitRate = winningStatistics.getTotalProfitRate();

        // then
        assertThat(totalProfitRate).isEqualTo(62.5);
    }

    private WinningResult createSampleWinningResult() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(new Lotto(numbers), bonusNumber);
        return new WinningResult(lottos, winningLotto);
    }
}
