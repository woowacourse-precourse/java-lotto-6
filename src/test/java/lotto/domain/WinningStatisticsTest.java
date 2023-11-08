package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {
    @Test
    @DisplayName("정상적으로 당첨 통계를 저장")
    void saveCorrectWinningStatistics() {
        // Given
        List<Lotto> randomLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10))
        );

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("7", winningLotto);

        Map<WinningRecord, Integer> result = new EnumMap<>(WinningRecord.class) {{
            put(WinningRecord.FIRST_PLACE, 1);
            put(WinningRecord.SECOND_PLACE, 1);
            put(WinningRecord.THIRD_PLACE, 1);
            put(WinningRecord.FOURTH_PLACE, 1);
            put(WinningRecord.FIFTH_PLACE, 1);
            put(WinningRecord.NONE, 0);
        }};

        // When
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.updateWinningStatistics(randomLotto, winningLotto, bonusNumber.getBonusNumber());

        // Then
        assertThat(winningStatistics.getWinningStatistics()).isEqualTo(result);
        assertThat(winningStatistics.getTotalPrize()).isEqualTo(2031555000);
    }

    @Test
    @DisplayName("정상적으로 수익률을 계산")
    void calculateWinningRateTest() {
        // Given
        List<Lotto> randomLotto = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("7", winningLotto);

        // When
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.updateWinningStatistics(randomLotto, winningLotto, bonusNumber.getBonusNumber());

        // Then
        assertThat(winningStatistics.getWinningRate(8000)).isEqualTo("62.5");
    }
}