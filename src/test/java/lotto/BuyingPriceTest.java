package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyingPriceTest {
    private BuyingPrice buyingPrice;

    @BeforeEach
    void setUp() {
        buyingPrice = new BuyingPrice();
    }

    @DisplayName("로또 구입 금액을 정상적으로 입력 받는다.")
    @Test
    void save() {
        buyingPrice.save("100000");
        assertThat(buyingPrice.getBuyingCount()).isEqualTo(100);
    }

    @DisplayName("로또 구입 금액이 1000원 이하일 경우 예외가 발생한다.")
    @Test
    void saveBuyingPriceByUnder1000() {
        assertThatThrownBy(() -> buyingPrice.save("900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void saveBuyingPriceByRestPrice() {
        assertThatThrownBy(() -> buyingPrice.save("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void saveBuyingPriceByNotNumber() {
        assertThatThrownBy(() -> buyingPrice.save("-1000"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> buyingPrice.save("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 10만원을 초과할 경우 예외가 발생한다.")
    @Test
    void saveBuyingPriceByOver100000() {
        assertThatThrownBy(() -> buyingPrice.save("101000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 공백이 포함되어 있을 경우 무시한다.")
    @Test
    void saveBuyingPriceByEmptyContainedNumber() {
        buyingPrice.save("10 00 00");
        assertThat(buyingPrice.getPrice()).isEqualTo(100000);
    }

    @DisplayName("로또 구입 금액이 공백을 제외하고 0자리인 경우 예외가 발생한다.")
    @Test
    void saveBuyingPriceByExceedBoundaryNumber() {
        assertThatThrownBy(() -> buyingPrice.save(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
