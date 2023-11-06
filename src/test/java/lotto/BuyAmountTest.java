package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyAmountTest {
    @DisplayName("입력한 구입 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    void createBuyAmountByUninteger() {
        assertThatThrownBy(() -> new BuyAmount("1000.4"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BuyAmount("10d"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BuyAmount("abcd"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력한 구입 금액이 1000의 단위가 아니면 예외가 발생한다.")
    @Test
    void createBuyAmountByWrongUnit() {
        assertThatThrownBy(() -> new BuyAmount("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
