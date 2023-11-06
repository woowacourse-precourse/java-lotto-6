package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Nested
    @DisplayName("맞은 개수와 보너스 개수를 비교하여 등수를 반환한다.")
    class WinningStatisticsOf {

        @Test
        void return_FIRST() {
            int matchCount = 6;
            int bonusCount = 0;

            WinningStatistics winningStatistics = WinningStatistics.of(matchCount, bonusCount);

            assertEquals(winningStatistics, WinningStatistics.FIRST);
        }

        @Test
        void return_SECOND() {
            int matchCount = 5;
            int bonusCount = 1;

            WinningStatistics winningStatistics = WinningStatistics.of(matchCount, bonusCount);

            assertEquals(winningStatistics, WinningStatistics.SECOND);
        }

        @Test
        void return_THIRD() {
            int matchCount = 5;
            int bonusCount = 0;

            WinningStatistics winningStatistics = WinningStatistics.of(matchCount, bonusCount);

            assertEquals(winningStatistics, WinningStatistics.THIRD);
        }

        @Test
        void return_FOURTH() {
            int matchCount = 4;
            int bonusCount = 0;

            WinningStatistics winningStatistics = WinningStatistics.of(matchCount, bonusCount);

            assertEquals(winningStatistics, WinningStatistics.FOURTH);
        }

        @Test
        void return_FIFTH() {
            int matchCount = 3;
            int bonusCount = 0;

            WinningStatistics winningStatistics = WinningStatistics.of(matchCount, bonusCount);

            assertEquals(winningStatistics, WinningStatistics.FIFTH);
        }

        @Test
        void return_MISS() {
            int matchCount = 0;
            int bonusCount = 0;

            WinningStatistics winningStatistics = WinningStatistics.of(matchCount, bonusCount);

            assertEquals(winningStatistics, WinningStatistics.MISS);
        }
    }
}
