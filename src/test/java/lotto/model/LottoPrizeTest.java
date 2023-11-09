package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPrizeTest {
    @DisplayName("구매한 로또와 주어진 당첨 번호와 보너스 번호와 비교해본다. 1등 LottoPrize 객체가 반환되지 않으면 테스트는 실패한다.")
    @Test
    void 로또_1등_당첨_테스트() {
        // given
        int matchedCount = 6;
        boolean bonusMatched = false;

        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchedCount, bonusMatched);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.FIRST);
    }

    @DisplayName("구매한 로또와 주어진 당첨 번호와 보너스 번호와 비교해본다. 2등 LottoPrize 객체가 반환되지 않으면 테스트는 실패한다.")
    @Test
    void 로또_2등_당첨_테스트() {
        // given
        int matchedCount = 5;
        boolean bonusMatched = true;

        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchedCount, bonusMatched);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND);
    }

    @DisplayName("구매한 로또와 주어진 당첨 번호와 보너스 번호와 비교해본다. 3등 LottoPrize 객체가 반환되지 않으면 테스트는 실패한다.")
    @Test
    void 로또_3등_당첨_테스트() {
        // given
        int matchedCount = 5;
        boolean bonusMatched = false;

        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchedCount, bonusMatched);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.THIRD);
    }

    @DisplayName("구매한 로또와 주어진 당첨 번호와 보너스 번호와 비교해본다. 4등 LottoPrize 객체가 반환되지 않으면 테스트는 실패한다.")
    @Test
    void 로또_4등_당첨_테스트() {
        // given
        int matchedCount = 4;
        boolean bonusMatched = true;

        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchedCount, bonusMatched);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.FOURTH);
    }

    @DisplayName("구매한 로또와 주어진 당첨 번호와 보너스 번호와 비교해본다. 5등 LottoPrize 객체가 반환되지 않으면 테스트는 실패한다.")
    @Test
    void 로또_5등_당첨_테스트() {
        // given
        int matchedCount = 3;
        boolean bonusMatched = true;

        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchedCount, bonusMatched);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.FIFTH);
    }
}
