package lotto.model;

import lotto.constants.Constants;
import lotto.exception.NotDivisibleByLottoPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {
    @DisplayName("로또 한장의 금액으로 나누어떨어지지 않는 금액이면 예외가 발생한다.")
    @Test
    void getPaymentIndivisibleByLottoPrice() {
        LottoShop lottoShop = new LottoShop();
        assertThatThrownBy(() -> lottoShop.sell(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(NotDivisibleByLottoPriceException.class);
    }

    @DisplayName("로또 한장의 금액으로 나누어떨지는 금액이면 그 몫만큼의 로또가 발행된다.")
    @Test
    void getPaymentDivisibleByLottoPrice() {
        LottoShop lottoShop = new LottoShop();
        int amount = 5;
        int payment = Constants.LOTTO_PRICE * amount;
        List<Lotto> purchasedLotto = lottoShop.sell(payment);
        assertThat(purchasedLotto.size())
                .isEqualTo(amount);
    }
}