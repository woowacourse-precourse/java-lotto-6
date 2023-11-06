package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {
    @Test
    @DisplayName("사용자가 입력한 금액을 로또의 갯수로 계산한다.")
    public void buyLottosTest() throws Exception {
        // given
        int money = 15000;

        // when
        LottoPurchase lottoPurchase = LottoPurchase.of(money);

        // then
        Assertions.assertThat(lottoPurchase.getCount()).isEqualTo(15);
    }
}
