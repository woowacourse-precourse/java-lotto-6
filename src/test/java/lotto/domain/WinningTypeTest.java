package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningTypeTest {
    @DisplayName("1등 당첨 조건은 6개 숫자가 맞아야 한다.")
    @Test
    void testFirstCondition() {
        assertThat(WinningType.FIRST.getMatchingCount())
                .isEqualTo(6);
    }

    @DisplayName("2등 당첨 조건은 5개 숫자가 맞고, 보너스 번호도 맞아야한다.")
    @Test
    void testSecondCondition() {
        assertThat(WinningType.SECOND.getMatchingCount())
                .isEqualTo(5);
        assertThat(WinningType.SECOND.getBonusMatching())
                .isEqualTo(true);
    }

    @DisplayName("3등 당첨 조건은 5개 숫자가 맞아야 한다. 보너스 번호는 틀려야 한다.")
    @Test
    void testThirdCondition() {
        assertThat(WinningType.THIRD.getMatchingCount())
                .isEqualTo(5);
        assertThat(WinningType.THIRD.getBonusMatching())
                .isEqualTo(false);
    }

    @DisplayName("4등 당첨 조건은 4개 숫자가 맞아야 한다.")
    @Test
    void testFourthCondition() {
        assertThat(WinningType.FOURTH.getMatchingCount())
                .isEqualTo(4);
    }

    @DisplayName("5등 당첨 조건은 3개 숫자가 맞아야 한다.")
    @Test
    void testFifthCondition() {
        assertThat(WinningType.FIFTH.getMatchingCount())
                .isEqualTo(3);
    }


    @DisplayName("1등 당첨금은 2,000,000,000원이다.")
    @Test
    void testFirstPrize() {
        assertThat(WinningType.FIRST.getPrice())
                .isEqualTo(2000000000L);
    }

    @DisplayName("2등 당첨금은 30,000,000원이다.")
    @Test
    void testSecondPrize() {
        assertThat(WinningType.SECOND.getPrice())
                .isEqualTo(30000000L);
    }

    @DisplayName("3등 당첨금은 1,500,000원이다.")
    @Test
    void testThirdPrize() {
        assertThat(WinningType.THIRD.getPrice())
                .isEqualTo(1500000L);
    }

    @DisplayName("4등 당첨금은 50,000원이다.")
    @Test
    void testFourthPrize() {
        assertThat(WinningType.FOURTH.getPrice())
                .isEqualTo(50000L);
    }

    @DisplayName("5등 당첨금은 5,000원이다.")
    @Test
    void testFifthPrize() {
        assertThat(WinningType.FIFTH.getPrice())
                .isEqualTo(5000L);
    }
}