package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.NotDivisibleByLottoPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest {
    @DisplayName("로또 한장의 금액으로 나누어떨어지지 않는 금액이면 예외가 발생한다.")
    @Test
    void getPaymentInDivisibleByLottoPrice() {
        LottoShop lottoShop = new LottoShop();
        assertThatThrownBy(() -> lottoShop.sell(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(NotDivisibleByLottoPriceException.class);
    }
}