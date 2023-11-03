package lotto.domain.constant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

    @DisplayName("맞춘 개수와 보너스 유무에 따라 등수와 상금을 반환한다.")
    @Test
    void getLottoPrize() {
        LottoPrize lottoPrize = LottoPrize.getLottoPrize(6, false);
        LottoPrize lottoPrize4th = LottoPrize.getLottoPrize(4, true);

        Assertions.assertThat(lottoPrize).isEqualTo(LottoPrize.FIRST);
        Assertions.assertThat(lottoPrize4th).isEqualTo(LottoPrize.FORTH);
    }

    @DisplayName("맞춘 개수와 보너스 유무에 따라 등수와 상금을 반환한다. - 2등, 3등")
    @Test
    void getLottoPrize_2nd_3rd() {
        LottoPrize lottoPrize2nd = LottoPrize.getLottoPrize(5, true);
        LottoPrize lottoPrize3rd = LottoPrize.getLottoPrize(5, false);

        Assertions.assertThat(lottoPrize2nd).isEqualTo(LottoPrize.SECOND);
        Assertions.assertThat(lottoPrize3rd).isEqualTo(LottoPrize.THIRD);
    }

    @DisplayName("맞춘 개수와 보너스 유무에 따라 등수와 상금을 반환한다. - 당첨이 되지 못했을 때")
    @Test
    void getLottoPrize_losing() {
        LottoPrize lottoPrize = LottoPrize.getLottoPrize(2, true);

        Assertions.assertThat(lottoPrize).isEqualTo(LottoPrize.LOSING);
    }
}