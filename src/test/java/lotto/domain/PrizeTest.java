package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    @Test
    @DisplayName("당첨 번호 6개 성공했으면 보너스 번호 일치 여부와 상관없이 1등")
    void firstPrize() {
        assertThat(Prize.findPrize(6, false))
                .isEqualTo(Prize.FIRST_PLACE);
        assertThat(Prize.findPrize(6, true))
                .isEqualTo(Prize.FIRST_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 5개와 보너스 번호 성공했으면 2등")
    void secondPrize() {
        assertThat(Prize.findPrize(5, true))
                .isEqualTo(Prize.SECOND_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 5개 성공했고 보너스 번호 일치 실패했으면 3등")
    void thirdPrize() {
        assertThat(Prize.findPrize(5, false))
                .isEqualTo(Prize.THIRD_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 4개 성공했으면 보너스 번호 일치 여부와 상관없이 4등")
    void fourthPrize() {
        assertThat(Prize.findPrize(4, true))
                .isEqualTo(Prize.FOURTH_PLACE);
        assertThat(Prize.findPrize(4, false))
                .isEqualTo(Prize.FOURTH_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 3개 성공했으면 보너스 번호 일치 여부와 상관없이 5등")
    void fifthPrize() {
        assertThat(Prize.findPrize(3, true))
                .isEqualTo(Prize.FIFTH_PLACE);
        assertThat(Prize.findPrize(3, false))
                .isEqualTo(Prize.FIFTH_PLACE);
    }

    @Test
    @DisplayName("2개 이하 성공은 모두 실패")
    void elsePrize() {
        assertThat(Prize.findPrize(2, true))
                .isEqualTo(Prize.NO_PRIZE);
        assertThat(Prize.findPrize(2, false))
                .isEqualTo(Prize.NO_PRIZE);
        assertThat(Prize.findPrize(1, true))
                .isEqualTo(Prize.NO_PRIZE);
        assertThat(Prize.findPrize(1, false))
                .isEqualTo(Prize.NO_PRIZE);
        assertThat(Prize.findPrize(0, true))
                .isEqualTo(Prize.NO_PRIZE);
        assertThat(Prize.findPrize(0, false))
                .isEqualTo(Prize.NO_PRIZE);
    }
}
