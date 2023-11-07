package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoPurchaseTest {

    @DisplayName("구매 금액만큼 정상적으로 구매 됐는지 체크")
    @Test
    void purchaseLottoCorrect() {
        //given
        final LottoPurchase lottoPurchase = new LottoPurchase();
        final String amount = "8000";
        final int correctCount = 8;

        //when
        final int lottoCount = lottoPurchase.lottoPurchaseCount(amount);

        //then
        assertThat(lottoCount).isEqualTo(correctCount);
    }


}
