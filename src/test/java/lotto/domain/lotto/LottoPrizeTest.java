package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoPrize 클래스")
class LottoPrizeTest {

    @DisplayName("일치 번호에 따라 정확한 상금을 찾아 반환한다.")
    @Test
    void returnLottoPrizeIfNumbersMatched() {
        assertThat(LottoPrize.FIFTH).isEqualTo(LottoPrize.findLottoPrize(3, false));
        assertThat(LottoPrize.FOURTH).isEqualTo(LottoPrize.findLottoPrize(4, false));
        assertThat(LottoPrize.THIRD).isEqualTo(LottoPrize.findLottoPrize(5, false));
        assertThat(LottoPrize.SECOND).isEqualTo(LottoPrize.findLottoPrize(4, false));
        assertThat(LottoPrize.FIRST).isEqualTo(LottoPrize.findLottoPrize(6, false));
    }

    @DisplayName("로또 당첨에 해당하지 않는다면 낙첨을 반환한다.")
    @Test
    void returnLoseIfNumbersNotMatched() {
        assertThat(LottoPrize.LOSE).isEqualTo(LottoPrize.findLottoPrize(2, false));
        assertThat(LottoPrize.LOSE).isEqualTo(LottoPrize.findLottoPrize(1, true));
    }

    @DisplayName("일치 번호가 4개이더라도 보너스 번호에 따라 2등과 4등으로 구별된다.")
    @Test
    void distinguishSecondOrFourthInBonusNumber() {
        int matchCount = 4;
        assertThat(LottoPrize.FOURTH)
            .isEqualTo(LottoPrize.findLottoPrize(matchCount, false));
        assertThat(LottoPrize.SECOND)
            .isEqualTo(LottoPrize.findLottoPrize(matchCount, true));
    }
}