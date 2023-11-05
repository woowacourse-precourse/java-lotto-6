package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningCriteriaTest {

    @Test
    @DisplayName("당첨 번호 6개 성공했으면 보너스 번호 일치 여부와 상관없이 1등")
    void firstPrize() {
        assertThat(WinningCriteria.findRanking(6, false))
                .isEqualTo(WinningCriteria.FIRST_PLACE);
        assertThat(WinningCriteria.findRanking(6, true))
                .isEqualTo(WinningCriteria.FIRST_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 5개와 보너스 번호 성공했으면 2등")
    void secondPrize() {
        assertThat(WinningCriteria.findRanking(5, true))
                .isEqualTo(WinningCriteria.SECOND_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 5개 성공했고 보너스 번호 일치 실패했으면 3등")
    void thirdPrize() {
        assertThat(WinningCriteria.findRanking(5, false))
                .isEqualTo(WinningCriteria.THIRD_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 4개 성공했으면 보너스 번호 일치 여부와 상관없이 4등")
    void fourthPrize() {
        assertThat(WinningCriteria.findRanking(4, true))
                .isEqualTo(WinningCriteria.FOURTH_PLACE);
        assertThat(WinningCriteria.findRanking(4, false))
                .isEqualTo(WinningCriteria.FOURTH_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 3개 성공했으면 보너스 번호 일치 여부와 상관없이 5등")
    void fifthPrize() {
        assertThat(WinningCriteria.findRanking(3, true))
                .isEqualTo(WinningCriteria.FIFTH_PLACE);
        assertThat(WinningCriteria.findRanking(3, false))
                .isEqualTo(WinningCriteria.FIFTH_PLACE);
    }

    @Test
    @DisplayName("2개 이하 성공은 모두 실패")
    void elsePrize() {
        assertThat(WinningCriteria.findRanking(2, true))
                .isEqualTo(WinningCriteria.NO_PRIZE);
        assertThat(WinningCriteria.findRanking(2, false))
                .isEqualTo(WinningCriteria.NO_PRIZE);
        assertThat(WinningCriteria.findRanking(1, true))
                .isEqualTo(WinningCriteria.NO_PRIZE);
        assertThat(WinningCriteria.findRanking(1, false))
                .isEqualTo(WinningCriteria.NO_PRIZE);
        assertThat(WinningCriteria.findRanking(0, true))
                .isEqualTo(WinningCriteria.NO_PRIZE);
        assertThat(WinningCriteria.findRanking(0, false))
                .isEqualTo(WinningCriteria.NO_PRIZE);
    }
}
