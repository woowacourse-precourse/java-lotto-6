package lotto.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningCriteriaTest {
    @DisplayName("매칭 개수가 5이고, 보너스 볼이 일치하면 2등이다.")
    @Test
    void testMatchingCountFiveWithBonusBall() {
        int matchingCount = 5;
        boolean isBonus = true;
        WinningCriteria expectedRating = WinningCriteria.SECOND;
        assertThat(WinningCriteria.getRating(matchingCount, isBonus)).isEqualTo(expectedRating);
    }

    @DisplayName("매칭 개수가 3이고, 보너스 볼이 일치하지 않으면 5등이다.")
    @Test
    void testMatchingCountThreeWithoutBonusBall() {
        int matchingCount = 3;
        boolean isBonus = false;
        WinningCriteria expectedRating = WinningCriteria.FIFTH;
        assertThat(WinningCriteria.getRating(matchingCount, isBonus)).isEqualTo(expectedRating);
    }
}
