package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    private static final int perfectMatch = 6, fiveMatch = 5, fourMatch = 4, threeMatch = 3, twoMatch = 2, oneMatch = 1, zeroMatch = 0;
    private static final boolean bonusMatched = true;

    @Test
    @DisplayName("당첨 번호 6개 성공했으면 보너스 번호 일치 여부와 상관없이 1등")
    void firstPrize() {
        assertThat(Prize.findPrize(perfectMatch, bonusMatched))
                .isEqualTo(Prize.FIRST_PLACE);
        assertThat(Prize.findPrize(perfectMatch, !bonusMatched))
                .isEqualTo(Prize.FIRST_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 5개와 보너스 번호 성공했으면 2등")
    void secondPrize() {
        int fiveMatch = 5;

        assertThat(Prize.findPrize(fiveMatch, bonusMatched))
                .isEqualTo(Prize.SECOND_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 5개 성공했고 보너스 번호 일치 실패했으면 3등")
    void thirdPrize() {
        assertThat(Prize.findPrize(fiveMatch, bonusNotMatched))
                .isEqualTo(Prize.THIRD_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 4개 성공했으면 보너스 번호 일치 여부와 상관없이 4등")
    void fourthPrize() {
        assertThat(Prize.findPrize(fourMatch, bonusNotMatched))
                .isEqualTo(Prize.FOURTH_PLACE);
        assertThat(Prize.findPrize(fourMatch, bonusMatched))
                .isEqualTo(Prize.FOURTH_PLACE);
    }

    @Test
    @DisplayName("당첨 번호 3개 성공했으면 보너스 번호 일치 여부와 상관없이 5등")
    void fifthPrize() {
        assertThat(Prize.findPrize(threeMatch, bonusNotMatched))
                .isEqualTo(Prize.FIFTH_PLACE);
        assertThat(Prize.findPrize(threeMatch, bonusMatched))
                .isEqualTo(Prize.FIFTH_PLACE);
    }

    @Test
    @DisplayName("2개 이하 성공은 모두 실패")
    void elsePrize() {
        assertThat(Prize.findPrize(twoMatch, bonusMatched))
                .isEqualTo(Prize.NO_PRIZE);
        assertThat(Prize.findPrize(twoMatch, bonusNotMatched))
                .isEqualTo(Prize.NO_PRIZE);
        assertThat(Prize.findPrize(oneMatch, bonusNotMatched))
                .isEqualTo(Prize.NO_PRIZE);
        assertThat(Prize.findPrize(oneMatch, bonusMatched))
                .isEqualTo(Prize.NO_PRIZE);
        assertThat(Prize.findPrize(zeroMatch, bonusMatched))
                .isEqualTo(Prize.NO_PRIZE);
        assertThat(Prize.findPrize(zeroMatch, bonusNotMatched))
                .isEqualTo(Prize.NO_PRIZE);
    }
}
