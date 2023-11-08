package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BuyerTest {

    @DisplayName("구매금액이 1,000원 이하라면 예외가 발생한다.")
    @Test
    void getCostUnderPrice() {
        assertThatThrownBy(() -> new Buyer(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매금액은 1,000원 이상이어야 합니다.");
    }

    @DisplayName("구매금액이 음수라면 예외가 발생한다.")
    @Test
    void getNegativeCost() {
        assertThatThrownBy(() -> new Buyer(-2000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매금액은 1,000원 이상이어야 합니다.");
    }

    @DisplayName("구매금액이 1,000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void getCostNotPriceUnits() {
        assertThatThrownBy(() -> new Buyer(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("구매가격으로 구매 로또 개수를 계산한다.")
    @Test
    void getBuyCount() {
        Buyer buyer = new Buyer(10000);

        int actual = buyer.getBuyCount();

        int expected = 10;
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}