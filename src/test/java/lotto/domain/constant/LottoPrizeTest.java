package lotto.domain.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @DisplayName("맞춘 개수와 보너스 유무에 따라 등수와 상금을 반환한다.")
    @Test
    void getLottoPrize() {
        LottoPrize lottoPrize = LottoPrize.getLottoPrize(6, false);
        LottoPrize lottoPrize4th = LottoPrize.getLottoPrize(4, true);

        assertThat(lottoPrize).isEqualTo(LottoPrize.FIRST);
        assertThat(lottoPrize4th).isEqualTo(LottoPrize.FORTH);
    }

    @DisplayName("맞춘 개수와 보너스 유무에 따라 등수와 상금을 반환한다. - 2등, 3등")
    @Test
    void getLottoPrize_2nd_3rd() {
        LottoPrize lottoPrize2nd = LottoPrize.getLottoPrize(5, true);
        LottoPrize lottoPrize3rd = LottoPrize.getLottoPrize(5, false);

        assertThat(lottoPrize2nd).isEqualTo(LottoPrize.SECOND);
        assertThat(lottoPrize3rd).isEqualTo(LottoPrize.THIRD);
    }

    @DisplayName("맞춘 개수와 보너스 유무에 따라 등수와 상금을 반환한다. - 당첨이 되지 못했을 때")
    @Test
    void getLottoPrize_losing() {
        LottoPrize lottoPrize = LottoPrize.getLottoPrize(2, true);

        assertThat(lottoPrize).isEqualTo(LottoPrize.LOSING);
    }

    @DisplayName("상에 따라 다른 메시지를 던진다")
    @Test
    void toMessage() {
        LottoPrize lottoPrize2nd = LottoPrize.getLottoPrize(5, true);
        LottoPrize lottoPrize3rd = LottoPrize.getLottoPrize(5, false);

        assertThat(lottoPrize2nd.toMessage()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");

        assertThat(lottoPrize3rd.toMessage()).isEqualTo("5개 일치 (1,500,000원)");
    }
}