package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.IntegerConstants;
import lotto.domain.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {
    @DisplayName("로또 가격으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void purchaseValueNotDivided() {
        assertThatThrownBy(() -> new LottoPurchase(IntegerConstants.LOTTO_PRICE - 1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoPurchase(IntegerConstants.LOTTO_PRICE + 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수인 구매 가격이 인자로 들어올 때 예외가 발생한다.")
    @Test
    void purchaseValueIsNegative() {
        assertThatThrownBy(() -> new LottoPurchase(-IntegerConstants.LOTTO_PRICE))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoPurchase(-2 * IntegerConstants.LOTTO_PRICE))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
