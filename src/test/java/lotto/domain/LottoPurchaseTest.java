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

    @Test
    @DisplayName("사용자가 입력한 금액이 0원 이하일 경우 예외가 발생한다.")
    public void buyLottosRangeExceptionTest1() throws Exception {
        // given
        int money = 0;

        // when
        // then
        Assertions.assertThatThrownBy(() -> LottoPurchase.of(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액을 0원 이상 입력해주세요.");
    }

    @Test
    @DisplayName("사용자가 입력한 금액이 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    public void buyLottosRangeExceptionTest2() throws Exception {
        // given
        int money = 1830;

        // when
        // then
        Assertions.assertThatThrownBy(() -> LottoPurchase.of(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액을 1000원 단위로 입력해주세요.");
    }
}
