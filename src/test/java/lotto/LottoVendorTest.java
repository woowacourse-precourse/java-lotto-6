package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoVendorTest {
    private static final Integer LOTTO_PRICE = LottoEnum.PRICE.getValue();

    @DisplayName("전달된 금액이 양수가 아니라면 예외가 발생한다.")
    @Test
    void purchaseWithoutMoney() {
        assertThatThrownBy(() -> new LottoVendor(LOTTO_PRICE).purchaseAll(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전달된 금액이 상품 가격의 배수가 아니라면 예외가 발생한다.")
    @Test
    void purchaseMadeExchange() {
        assertThatThrownBy(() -> new LottoVendor(LOTTO_PRICE).purchaseAll(LOTTO_PRICE + 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
