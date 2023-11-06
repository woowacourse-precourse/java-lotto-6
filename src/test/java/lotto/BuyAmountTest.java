package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("구입한 금액에 따라 구매 개수를 반환한다.")
    @Test
    void 구매_개수_테스트(){
        assertThat(new BuyAmount("8000").getBuyCount())
                .isEqualTo(8);
    }

}
